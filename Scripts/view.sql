-- 도서 전체 검색 view
create view vw_book as 
	select b1.book_code , b1.book_name, b1.authr_name , b1.trnslr_name , b1.pls, p.pls_name , b1.pblicte_year ,
	   b1.book_price , b2.book_cnt, b1.lend_psb_cdt , b1.total_le_cnt , b1.book_img , b1.lc_no, l.lclas_name , b1.ml_no,
	   b1.regist_date , b1.dsuse_cdt
	from book b1 
		left join publishing_company p on b1.pls = p.pls_no left join large_classification l on b1.lc_no = l.lclas_no 
		left join middle_classification m on m.mlsfc_no = b1.ml_no and l.lclas_no = m.lclas_no,
		(select book_name, authr_name , pls, pblicte_year , book_price , count(*) as book_cnt from book group by book_name, authr_name , pls, pblicte_year , book_price) b2
	where b1.book_name = b2.book_name and b1.authr_name = b2.authr_name and b1.pls = b2.pls and b1.pblicte_year = b2.pblicte_year and 
			b1.book_price = b2.book_price 
	order by b1.regist_date;
	
-- 신청도서 전체검색 view
create view vw_request_book as 
select reqst_book_no , rb1.reqst_book_name , reqst_book_author , reqst_book_trnslr , request_book_pls , 
	reqst_mb_id , reqst_date , wh_cdt , rb2.cnt
	from request_book rb1, 
		(select reqst_book_name , count(*) as cnt from request_book group by reqst_book_name) rb2
	where rb1.reqst_book_name = rb2.reqst_book_name;
	
-- 대여 프로시저(회원 아이디, 도서코드)
drop procedure if exists rent_book;

delimiter $$
$$
create procedure rent_book(in _mber_id varchar(30), in _book_cd char(7))

begin
	declare continue handler for sqlexception
	begin
		select '오류 발생했습니다.';
		rollback;
	end;
	set AUTOCOMMIT = 0;
	start transaction;
		-- 회원 테이블에 총대여권수, 대여도서권수가 대여한 숫자만큼  증가시키는 업데이트
		update member
			set total_le_cnt = total_le_cnt + 1, lend_book_cnt = lend_book_cnt +1
			where mber_id = _mber_id;
			
		-- 도서 테이블에 대여가능여부, 총대여횟수가 1로 바뀌고 , 1이 증가하여야 한다
		update book 
			set lend_psb_cdt = 1, total_le_cnt = total_le_cnt +1
			where book_code = _book_cd;
	
		-- 대여반납 테이블에 대여 도서정보가 등록
		INSERT INTO lending
		(mber_id, book_cd, lend_date, rturn_due_date, rturn_psm_cdt, rturn_date, overdue_cdt)
		VALUES(_mber_id, _book_cd, curdate(), ADDDATE(curdate(), 15), 0, null, 0);
	
	commit;
	set AUTOCOMMIT = 1;
end $$

delimiter ;







-- 반납 프로시저 테스트(회원 아이디, 도서코드)
drop procedure if exists return_book;

delimiter $$
$$
create procedure return_book(in _mber_id varchar(30), in _book_cd char(7))

begin
	declare continue handler for sqlexception
	begin
		select '오류 발생했습니다.';
		rollback;
	end;
	set AUTOCOMMIT = 0;
	start transaction;
		-- 반납대여 테이블
		/* 반납대여 테이블에서 반납일의 null값을 반납날짜로 업데이트*/
		update lending 
			set rturn_date = date_format(curdate(), "%Y-%m-%d")
			where rturn_date is null and book_cd = _book_cd;			
		/* 반납대여 테이블에서 반납일이 반납예정일보다 늦다는 조건에 부합할시  연체여부의 값을 연체로 업데이트, 
		 * 반납일이 반납예정일과 같거나 빠를시는 적용 x */
		update lending
			set overdue_cdt = 1
			where DATEDIFF(rturn_date, rturn_due_date ) > 0;
		
		-- 도서 테이블
		/* 반납이 이루어졌을 경우 책 테이블의 대여가능유무를 대여가능으로 업데이트 */
		update lending l left join book b 
			on l.book_cd = b.book_code
			set lend_psb_cdt = 0
			where rturn_date is not null;
		
		-- 회원 테이블
		-- 회원 테이블의 특정 회원의 대여도서권수(=대여반납 테이블에 반납일이 없는 행의 수)를 감소시키기() 위한 업데이트
		update member
			set lend_book_cnt = lend_book_cnt -1
			where mber_id = _mber_id;
		-- 특정 회원이 도서를 반납했을 경우 반납날을 기준으로 반납예정일 보다 늦었을 경우 회원 테이블의 연체횟수가 1 증가
		update member m left join lending l
			on m.mber_id = l.mber_id
			set od_cnt = od_cnt +1
			where l.rturn_date = curdate() and l.overdue_cdt = 1 and m.mber_id = _mber_id; 
		-- 회원 테이블의 연체횟수가 5회 이상일시 대여가능여부를 업데이트 
		update member
			set lend_psb_cdt = 1
			where od_cnt>4;
	commit;
	set AUTOCOMMIT = 1;
end $$

delimiter ;