select user(), database ();

desc lending;
select * from lending;

select m.mber_id , m.mber_name , g.grad_name , m.lend_psb_cdt , (g.book_le_cnt - count(l.rturn_date)) as 'lend_book_cdt'
	from member m left join lending l on m.mber_id = l.mber_id left join grade g on m.grade = g.grade_no 
	where m.mber_id = 'daddystop@gmail.com' and l.rturn_date = '0000-00-00 00:00:00';

select l.book_cd , b.book_name , l.mber_id , m.mber_name , l.lend_date, l.rturn_due_date , l.overdue_date 
	from lending l left join book b on l.book_cd = b.book_code left join member m on l.mber_id = m.mber_id
	where overdue_cdt = 1;

select pls from book;
select pls_no from publishing_company;




select l.book_cd , b.book_name , concat(b.authr_name, "/",b.trnslr_name )as 'authr_name', b.pblicte_year , p.pls_name, l.lend_date ,l.rturn_due_date ,l.overdue_date 
	from lending l left join book b on l.book_cd = b.book_code left join member m on l.mber_id = m.mber_id left join publishing_company p on b.pls = p.pls_no 
	where l.mber_id = 'daddystop@gmail.com';

select l.book_cd , b.book_name , if(isnull(b.trnslr_name), b.authr_name, concat(b.authr_name ,"/", b.trnslr_name ) )as 'authr_name', b.pblicte_year , p.pls_name, l.lend_date ,l.rturn_due_date ,l.overdue_date 
	from lending l left join book b on l.book_cd = b.book_code left join member m on l.mber_id = m.mber_id left join publishing_company p on b.pls = p.pls_no 
	where l.mber_id = 'daddystop@gmail.com';

select l.book_cd , b.book_name , if(b.trnslr_name = null, b.authr_name, concat(b.authr_name ,"/", b.trnslr_name ) )as 'authr_name', b.pblicte_year , p.pls_name, l.lend_date ,l.rturn_due_date ,l.overdue_date 
	from lending l left join book b on l.book_cd = b.book_code left join member m on l.mber_id = m.mber_id left join publishing_company p on b.pls = p.pls_no 
	where l.mber_id = 'daddystop@gmail.com';

select *
	from `member` m ;


desc `member`;

select mber_id, mber_pass, mber_name, mber_brthdy, mber_zip,mber_bass_ad,mber_detail_ad,mber_tel,mber_img,total_le_cnt,lend_book_cnt,grade ,lend_psb_cdt ,join_dt ,wdr_cdt ,od_cnt 
	from member
	where mber_id = 'daddystop@gmail.com';

select *
	from lending
	where rturn_date is null;

select *
	from lending;

select book_code ,book_name ,authr_name ,trnslr_name , pls, pblicte_year ,book_price ,lend_psb_cdt ,total_le_cnt ,book_img , lc_no , ml_no , regist_date , dsuse_cdt 
	from book
	where book_code = 'A090101';
select * 
	from book
	where book_code = 'A090101';
select book_code ,book_name ,authr_name ,trnslr_name , concat(b.pls,"/",p.pls_name ) as 'pls', pblicte_year ,book_price ,lend_psb_cdt ,total_le_cnt ,book_img , lc_no , ml_no , regist_date , dsuse_cdt 
	from book b left join publishing_company p on b.pls = p.pls_no 
	where book_code = 'A090101';
select book_code ,book_name ,authr_name ,trnslr_name , pls, p.pls_name, pblicte_year ,book_price ,lend_psb_cdt ,total_le_cnt ,book_img , lc_no , ml_no , regist_date , dsuse_cdt 
	from book b left join publishing_company p on b.pls = p.pls_no 
	where book_code = 'A090101';
	


desc book;

desc publishing_company;

select mber_id, mber_pass, mber_name, mber_brthdy, mber_zip, mber_bass_ad, mber_detail_ad, mber_tel, mber_img, total_le_cnt, lend_book_cnt, grade, grad_name, book_le_cnt, lend_psb_cdt, join_dt, wdr_cdt from member m left join grade g on m.grade = g.grade_no where mber_id = 'daddystop@gmail.com';


select lend_rturn_no, mber_id ,book_cd , lend_date ,rturn_due_date , rturn_psm_cdt , rturn_date , overdue_cdt 
	from lending
	where mber_id = 'daddystop@gmail.com';

select lend_rturn_no, mber_id ,book_cd , lend_date ,rturn_due_date , rturn_psm_cdt , rturn_date , overdue_cdt 
	from lending
	where rturn_date is null;

select book_code, book_name, authr_name, pblicte_year, pls_name, lend_date, rturn_date from lending l left join book b on l.book_cd = b.book_code left join publishing_company p on b.pls = p.pls_no where mber_id = 'mamatellme@gmail.com' and rturn_date is null ;

select book_code, book_name, authr_name, trnslr_name, pls, pblicte_year, book_price,b.lend_psb_cdt , b.total_le_cnt, book_img, lc_no, ml_no, lend_date, rturn_date, rturn_due_date, od_cnt 
	from lending l left join book b on l.book_cd = b.book_code left join publishing_company p on b.pls = p.pls_no left join member m on l.mber_id = m.mber_id 
	where l.mber_id = 'mamatellme@gmail.com' and rturn_date is null ;
	

select *
	from lending l 
	where rturn_date is null;
	
select  date_format(curdate(), "%Y-%m-%d"); 


SELECT mber_id, mber_pass, mber_name, mber_brthdy, mber_zip, mber_bass_ad, mber_detail_ad, mber_tel, mber_img, total_le_cnt, lend_book_cnt, grade, lend_psb_cdt, join_dt, wdr_cdt, od_cnt
FROM yi_java3st_3team.`member`
where mber_id = 'ya2354fr@yahoo.com';


select total_le_cnt, lend_book_cnt, lend_book_cnt 
	from member
	where mber_id = 'ddr23dd@naver.com';

select lend_psb_cdt, total_le_cnt 
	from book
	where book_code = 'B040110';
select lend_psb_cdt, total_le_cnt 
	from book
	where book_code = 'A090119';

select * 
	from lending
	where mber_id = 'ddr23dd@naver.com';


select b1.book_code , b1.book_name, b1.authr_name , b1.trnslr_name , b1.pls, p.pls_name , b1.pblicte_year , 
	   b1.book_price , b2.book_cnt, b1.lend_psb_cdt , b1.total_le_cnt , b1.book_img , b1.lc_no, l.lclas_name , b1.ml_no , m.mlsfc_name , 
	   b1.regist_date , b1.dsuse_cdt
	from book b1 
		left join publishing_company p on b1.pls = p.pls_no left join large_classification l on b1.lc_no = l.lclas_no 
		left join middle_classification m on m.mlsfc_no = b1.ml_no and l.lclas_no = m.lclas_no, 
		(select book_name, authr_name , pls, pblicte_year , book_price , count(*) as book_cnt from book group by book_name, authr_name , pls, pblicte_year , book_price) b2 
	where b1.book_name = b2.book_name and b1.authr_name = b2.authr_name and b1.pls = b2.pls and b1.pblicte_year = b2.pblicte_year and b1.book_price = b2.book_price and
		  b1.book_code = 'B040110';
		 
select  curdate();
select  ADDDATE(curdate(), 15);


/* 1권을 반납한다고 가정했을 때  */

-- 회원 테이블에 총대여권수, 대여도서권수가 대여한 숫자만큼  증가시키는 업데이트
update member
	set total_le_cnt = total_le_cnt + 1, lend_book_cnt = lend_book_cnt +1
	where mber_id = 'ya2354fr@yahoo.com';

-- 도서 테이블에 대여가능여부, 총대여횟수가 1로 바뀌고 , 1이 증가하여야 한다
update book 
	set lend_psb_cdt = 1, total_le_cnt = total_le_cnt +1
	where book_code = 'A090251';

-- 대여반납 테이블에 대여 도서정보가 등록
INSERT INTO lending
(mber_id, book_cd, lend_date, rturn_due_date, rturn_psm_cdt, rturn_date, overdue_cdt)
VALUES('ya2354fr@yahoo.com', 'A090251', curdate(), ADDDATE(curdate(), 15), 0, null, 0);



-- 대여 프로시저 테스트(회원 아이디, 도서코드)
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

call rent_book('ddr23dd@naver.com', 'B040110'); 

--------------------------------------------------- -----------------------------------------------
select total_le_cnt, lend_book_cnt
	from member
	where mber_id = 'ssdfr@daum.net';

select lend_psb_cdt, total_le_cnt 
	from book
	where book_code = 'A090101';

select count(*) 
	from lending;

select * 
	from lending
	where mber_id = 'ssdfr@daum.net';



select *
from librarian;

select *
	from `member` m;


update member
	set od_cnt = od_cnt+1
	where mber_id = 'ssdfr@daum.net';

select od_cnt
	from `member` m 
	where mber_id = 'ssdfr@daum.net';




select m.mber_name,b.book_name , l.rturn_date , l.overdue_cdt 
 from lending l left join book b on l.book_cd = b.book_code left join member m on l.mber_id = m.mber_id  
 where m.mber_name= '조조';



select *
	from member 
	where mber_name = '조조';

select * 
	from lending
	where rturn








-- 반납대여 테이블
/* 반납대여 테이블에서 반납일의 null값을 반납날짜로 업데이트*/
update lending 
	set rturn_date = date_format(curdate(), "%Y-%m-%d")
	where rturn_date is null and book_cd in ('B040110', 'B040111)';
	
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
-- update member m left join lending l
-- 	on m.mber_id = l.mber_id left join grade g on m.grade = g.grade_no
-- 	set lend_book_cnt = if((g.book_le_cnt -(g.book_le_cnt - count(l.rturn_date is null))) is null, 0, (g.book_le_cnt -(g.book_le_cnt - count(l.rturn_date is null))))
-- 	where m.mber_id = 'phonehu@gmail.com' and l.rturn_date is null;
-- 
-- select if((g.book_le_cnt -(g.book_le_cnt - count(l.rturn_date is null))) is null, 0, (g.book_le_cnt -(g.book_le_cnt - count(l.rturn_date is null)))) as 'lend_book_cnt'
-- 	from member m left join lending l on m.mber_id = l.mber_id left join grade g on m.grade = g.grade_no 
-- 	where m.mber_id = 'phonehu@gmail.com' and l.rturn_date is null;
-- 
-- select count( l.rturn_date is null)
-- 	from member m left join lending l on m.mber_id = l.mber_id
-- 	where m.mber_id = 'phonehu@gmail.com' and l.rturn_date is null
-- 	group by m.mber_id ;
-- 
-- drop trigger if exists cnt_rturn_date_null;
-- 
-- create trigger cnt_rturn_date_null

-- select count(rturn_date ) 
-- 	from lending
-- 	where mber_id ='ddr23dd@naver.com' and rturn_date is null;
-- 
-- update member m join lending l
-- 	on m.mber_id = l.mber_id 
-- 	set m.lend_book_cnt = count(l.rturn_date)
-- 	where m.mber_id ='ddr23dd@naver.com' and rturn_date is null;

update member
	set lend_book_cnt = lend_book_cnt -1
	where mber_id = 'ddr23dd@naver.com';


-- 특정 회원이 도서를 반납했을 경우 반납날을 기준으로 반납예정일 보다 늦었을 경우 회원 테이블의 연체횟수가 1 증가
update member m left join lending l
	on m.mber_id = l.mber_id
	set od_cnt = od_cnt +1
	where l.rturn_date = curdate() and l.overdue_cdt = 1 and m.mber_id = 'ddr23dd@naver.com'; 
-- 회원 테이블의 연체횟수가 5회 이상일시 대여가능여부를 업데이트 
update member
	set lend_psb_cdt = 1
	where od_cnt>4;


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

call return_book('ddr23dd@naver.com', 'B040110');




--------------------------------------------------------------------








select date_format((rturn_date -rturn_due_date), "%Y-%m-%d")
	from lending;

select DATEDIFF(rturn_date, rturn_due_date )
	from lending;
select rturn_date, rturn_due_date 
	from lending;


select overdue_cdt 
	from lending
	where DATEDIFF(rturn_date, rturn_due_date ) > 0;







select total_le_cnt, lend_psb_cdt 
	from book;

	
/* 도서 테이블에 총 대여 권수가 모두 0이라 이런식으로 값을 넣기 위해 조회*/	
select book_name, count(book_cd) 
	from lending l left join book b on l.book_cd = b.book_code
	group by book_name;
	
select l.mber_id, m.mber_name , date_format(l.rturn_date, "%Y-%m-%d") as 'rturn_date', count(l.book_cd) 
	from lending l left join member m on l.mber_id = m.mber_id
	group by l.mber_id ;

/*  특정 회원이 반납을 했을시 반납일을 기준으로 연체가 되었는지를 판단 */
select mber_id, rturn_date,overdue_cdt, count(book_cd) 
	from lending
	where mber_id  = 'phonehu@gmail.com'
	group by rturn_date;

/* 회원별 총대여횟수를 조회*/
select m.mber_id, m.total_le_cnt 
	from lending l left join member m on l.mber_id = m.mber_id
	group by m.mber_id;
	
/* 대여반납 테이블의 회원별 대여횟수 조회*/
select mber_id, count(book_cd)
	from lending
	group by mber_id;

-- update member m
-- 	set total_le_cnt = (select count(book_cd)
-- 							from lending 
-- 							group by mber_id) l
-- 	where m.mber_id = l.mber_id;


/* 특정 날에 특정 회원의 연체도서 갯수 */
select count(l.overdue_cdt) 
	from member m left join lending l on m.mber_id = l.mber_id 
	where l.mber_id = 'phonehu@gmail.com' and l.rturn_date = '2020-03-17' and l.overdue_cdt = 1;

/* 특정 날에 특정 회원의 연체도서 갯수가 1이상이면 연체 횟수를 증가시키기 위한 테스트 */
select (m.od_cnt +if(count(l.overdue_cdt)>=1, 1, 0)) 
	from member m left join lending l on m.mber_id = l.mber_id 
	where l.mber_id = 'phonehu@gmail.com' and l.rturn_date = '2020-03-17' and l.overdue_cdt = 1;


/* 테스트중 */
update member m left join lending l
	on m.mber_id = l.mber_id 
	set od_cnt = (select (m2.od_cnt +if(count(l2.overdue_cdt)>=1, 1, 0)) 
	from member m2 left join lending l2 on m2.mber_id = l2.mber_id 
	where l2.mber_id = 'phonehu@gmail.com' and l2.rturn_date = '2020-03-17' and l2.overdue_cdt = 0)
	where l.mber_id = 'phonehu@gmail.com' and l.rturn_date = '2020-03-17' and l.overdue_cdt = 0;



drop procedure if exists member_someday_overdue_cdt;

delimiter $$
$$
create procedure member_someday_overdue_cdt(
		in _mber_id varchar(30),
		in _rturn_date DATE,
		out _od_cnt int
)
BEGIN
	declare _over_cdt int;
			
	select (m.od_cnt +if(count(l.overdue_cdt)>=1, 1, 0)) into _over_cdt
		from member m left join lending l on m.mber_id = l.mber_id 
		where l.mber_id = _mber_id and l.rturn_date = _rturn_date and l.overdue_cdt = 1;
			
	update member
		set od_cnt = od_cnt + _over_cdt
		where mber_id = _mber_id;
end $$
delimiter ;

call member_someday_overdue_cdt ('phonehu@gmail.com', '2020-03-17');












select m.mber_id, if(total_le_cnt = null? 0, )
	from member m left join lending l on m.mber_id = l.mber_id;





DELIMITER $$
$$
CREATE PROCEDURE update_lending ()

BEGIN
	DECLARE _rtun_date date;
	DECLARE _overdue_cdt tinyint;

	DECLARE exit handler for SQLEXCEPTION
		BEGIN
			ROLLBACK;        
			SET RESULT = -1;  
		END;

	START TRANSACTION;
		update lending 
			set rturn_date = date_format(curdate(), "%Y-%m-%d")
			where rturn_date is null;
		
		update lending
			set overdue_cdt = 1
			where DATEDIFF(rturn_date, rturn_due_date ) > 0;
		
		
		

	/* 커밋 */
	COMMIT;
	SET RESULT = 0;
END$$
DELIMITER ;


select total_le_cnt, lend_book_cnt, lend_book_cnt 
	from member
	where mber_id = 'ddr23dd@naver.com';

select lend_psb_cdt, total_le_cnt 
	from book
	where book_code = 'B040110';
select lend_psb_cdt, total_le_cnt 
	from book
	where book_code = 'A090119';

select * 
	from lending l left join book b on l.book_cd = b.book_code 
	where mber_id = 'ddr23dd@naver.com';



select mber_id,mber_pass,mber_name,mber_brthdy,mber_zip,mber_bass_ad,mber_detail_ad,mber_tel,mber_img,total_le_cnt,lend_book_cnt,
	grade,grad_name,book_le_cnt,lend_psb_cdt,join_dt,wdr_cdt
from
	member m left join grade g on m.grade = g.grade_no
where
	mber_name like '%조%';




select mber_id, mber_name, mber_brthdy, mber_zip, mber_bass_ad, mber_detail_ad, mber_tel, mber_img, total_le_cnt, lend_book_cnt, grade, join_dt , wdr_cdt, lend_psb_cdt, od_cnt
from member
where mber_id like '%23%'; 

select mber_id, mber_name, mber_brthdy, mber_zip, mber_bass_ad, mber_detail_ad, mber_tel, mber_img, total_le_cnt, lend_book_cnt, grade, join_dt , wdr_cdt, lend_psb_cdt, od_cnt, g.book_le_cnt, g.grad_name
from member m left join grade g on m.grade = g.grade_no 
where mber_id like '%23%'; 


select *
from book;

desc `member` ;

desc lending ;
desc book;

call rent_book('0101.001-1', 'ddr23dd@naver.com');
call return_book('0101.001-1', 'ddr23dd@naver.com');


select @@global.sql_mode;

set @@global.sql_mode = "ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION";

INSERT INTO book
(book_code, book_name, authr_name, trnslr_name, pls, pblicte_year, book_price, lend_psb_cdt, total_le_cnt, book_img, lc_no, ml_no, regist_date, dsuse_cdt)
VALUES('1002.016-1', '테스트', '테스트', '테스트', 196, '2020-03-22', 14000, 0, 0, null, 10, 2, '2020-03-22', 0);

select book_code ,book_name ,authr_name ,trnslr_name , pls, p.pls_name, pblicte_year ,book_price ,lend_psb_cdt ,total_le_cnt ,book_img , lc_no , ml_no , regist_date , dsuse_cdt
	from book b left join publishing_company p on b.pls = p.pls_no
	where book_name like '%누구%' and lend_psb_cdt = 0; 
select book_code ,book_name ,authr_name ,trnslr_name , pls, p.pls_name, pblicte_year ,book_price ,lend_psb_cdt ,total_le_cnt ,book_img , lc_no , ml_no , regist_date , dsuse_cdt
	from book b left join publishing_company p on b.pls = p.pls_no
	where book_code like '%01%' and lend_psb_cdt = 0; 
	

drop procedure if exists rent_book;

delimiter $$
$$
create procedure rent_book(in _mber_id varchar(30), in _book_cd char(20))

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
			where mber_id = 'ddr23dd@naver.com';
			
		-- 도서 테이블에 대여가능여부, 총대여횟수가 1로 바뀌고 , 1이 증가하여야 한다
		update book 
			set lend_psb_cdt = 1, total_le_cnt = total_le_cnt +1
			where book_code = '0902.001-1';
	
		-- 대여반납 테이블에 대여 도서정보가 등록
		INSERT INTO lending
		(mber_id, book_cd, lend_date, rturn_due_date, rturn_psm_cdt, rturn_date, overdue_cdt)
		VALUES('ddr23dd@naver.com', '0902.001-1', curdate(), ADDDATE(curdate(), 15), 0, null, 0);
	
	commit;
	set AUTOCOMMIT = 1;
end $$

delimiter ;

select book_name ,authr_name ,trnslr_name 
	from book;
	where book_code like '1%';
	

select *
	from librarian l;
	
select *
	from lending l left join book b on l.book_cd = b.book_code 
	where mber_id = 'rwe232@gamil.com';

select *
	from `member` m ;


update member m left join lending l
	on m.mber_id = l.mber_id
	set od_cnt = od_cnt +1
	where l.rturn_date = curdate() and l.overdue_cdt = 1 and m.mber_id = 'xodnjs1218@naver.com';


select count(*)  
	from member m left join lending l on m.mber_id = l.mber_id
	where l.rturn_date = curdate() and l.overdue_cdt = 1 and m.mber_id = 'xodnjs1218@naver.com';
	
-- 반납 프로시저 테스트2(회원 아이디)
drop procedure if exists return_book_od_cnt;

delimiter $$
$$
create procedure return_book_od_cnt(in _mber_id varchar(30))

begin
	declare _od_cnt int;
	declare continue handler for sqlexception
	begin
		select '오류 발생했습니다.';
		rollback;
	end;
	set AUTOCOMMIT = 0;
	start transaction;
		-- 회원 테이블
		-- 특정 회원이 도서를 반납했을 경우 반납도서를 카운트
		select count(*) into _od_cnt
			from member m left join lending l on m.mber_id = l.mber_id
			where l.rturn_date = curdate() and l.overdue_cdt = 1 and m.mber_id = _mber_id;
		-- 특정 회원이 도서를 반납했을 경우 반납날을 기준으로 반납예정일 보다 늦었을 경우 회원 테이블의 연체횟수가 1 증가
		if _od_cnt >= 1 then
			update member m left join lending l
				on m.mber_id = l.mber_id
				set od_cnt = od_cnt +1
				where l.rturn_date = curdate() and l.overdue_cdt = 1 and m.mber_id = _mber_id; 
		end if;
		-- 회원 테이블의 연체횟수가 5회 이상일시 대여가능여부를 업데이트 
		update member
			set lend_psb_cdt = 1
			where od_cnt>4;
	commit;
	set AUTOCOMMIT = 1;
end $$

delimiter ;









select *
	from member m left join lending l on m.mber_id = l.mber_id
	where l.rturn_date = curdate() and l.overdue_cdt = 1 and m.mber_id = 'xodnjs1218@naver.com';


update member m left join lending l
	on m.mber_id = l.mber_id
	set od_cnt = od_cnt +1
	where l.rturn_date = curdate() and l.overdue_cdt = 1 and m.mber_id = 'xodnjs1218@naver.com';


select count(*)  
	from member m left join lending l on m.mber_id = l.mber_id
	where l.rturn_date = curdate() and l.overdue_cdt = 1 and m.mber_id = 'xodnjs1218@naver.com';

select od_cnt 
	from `member` m 
	where mber_id = 'xodnjs1218@naver.com';


select *
	from lending
	where mber_id = 'xodnjs1218@naver.com';

select count(*) 
	from member m left join lending l on m.mber_id = l.mber_id
	where l.rturn_date = curdate() and l.overdue_cdt = 1 and m.mber_id = 'xodnjs1218@naver.com';
select count(*) 
	from member m left join lending l on m.mber_id = l.mber_id
	where l.rturn_date = curdate() and l.overdue_cdt = 0 and m.mber_id = 'xodnjs1218@naver.com';
select count(*) 
	from member m left join lending l on m.mber_id = l.mber_id
	where l.rturn_date = curdate() and m.mber_id = 'xodnjs1218@naver.com';


-- 반납 프로시저 테스트2(회원 아이디)
drop procedure if exists return_book_od_cnt;

delimiter $$
$$
create procedure return_book_od_cnt(in _mber_id varchar(30))

begin
	declare _od_cnt1 int;
	declare continue handler for sqlexception
	begin
		select '오류 발생했습니다.';
		rollback;
	end;
	set AUTOCOMMIT = 0;
	start transaction;
		-- 회원 테이블
		-- 특정 회원이 도서를 반납했을 경우 반납일을 기준으로 연체도서를 카운트
		select * into _od_cnt1
			from lending
			where mber_id = _mber_id and rturn_date is null and rturn_due_date <curdate();
		-- 특정 회원이 도서를 반납했을 경우 반납날을 기준으로 반납예정일 보다 늦었을 경우 회원 테이블의 연체횟수가 1 증가
		if _od_cnt >= 1 then
			update member m left join lending l
				on m.mber_id = l.mber_id
				set od_cnt = od_cnt +1
				where m.mber_id = _mber_id; 
		end if;
	commit;
	set AUTOCOMMIT = 1;
end $$

delimiter ;

select *
	from lending l 
	where DATEDIFF(rturn_date, rturn_due_date ) > 0;


select *
	from lending
	where mber_id = 'ku23324@naver.com' and rturn_date is null;

select *
	from librarian l ;


select * 
	from member m left join lending l on m.mber_id = l.mber_id
	where l.rturn_date is null and l.overdue_cdt = 0 and m.mber_id = 'xodnjs1218@naver.com';
select * 
	from member m left join lending l on m.mber_id = l.mber_id
	where l.rturn_date = '0000-00-00 00:00:00' and l.overdue_cdt = 0 and m.mber_id = 'xodnjs1218@naver.com';
select *
	from lending
	where mber_id = 'xodnjs1218@naver.com' and rturn_date is null and rturn_due_date <curdate();
select *
	from lending
	where mber_id = 'xodnjs1218@naver.com' and rturn_date curdate() and rturn_due_date <curdate();
	







select *
	from lending
	where mber_id = 'xodnjs1218@naver.com';


select m.od_cnt 
	from lending l join member m on l.mber_id = m.mber_id 
	where l.mber_id = 'xodnjs1218@naver.com' and l.rturn_date != curdate() and l.rturn_due_date <curdate();
select l.overdue_cdt, l.rturn_date 
	from lending l join member m on l.mber_id = m.mber_id 
	where l.mber_id = 'xodnjs1218@naver.com' and l.rturn_date != curdate() and l.rturn_due_date <curdate()
	group by l.rturn_date ;

select od_cnt
	from member m left join lending l on m.mber_id = l.mber_id
	where m.mber_id = 'xodnjs1218@naver.com'and rturn_date != curdate() and rturn_due_date <curdate(); 
select count(*) 
	from member m left join lending l on m.mber_id = l.mber_id
	where m.mber_id = 'xodnjs1218@naver.com'and rturn_date = curdate() and rturn_due_date <curdate();
select od_cnt
	from `member` m 
	where mber_id = 'xodnjs1218@naver.com';
	

select count(*) 
	from lending
	where mber_id = 'xodnjs1218@naver.com' and rturn_date is null and rturn_due_date <curdate();
select * 
	from lending
	where mber_id = 'xodnjs1218@naver.com' and rturn_date is null and rturn_due_date <curdate();
select * 
	from lending
	where mber_id = 'xodnjs1218@naver.com'  and rturn_due_date <curdate() and overdue_cdt =1
	group by rturn_date;
select * 
	from lending
	where mber_id = 'xodnjs1218@naver.com'  and rturn_due_date <curdate()
	group by rturn_date;
select count(overdue_cdt )
	from lending
	where mber_id = 'xodnjs1218@naver.com' and overdue_cdt =1
	group by rturn_date;
select * 
	from lending
	where mber_id = 'xodnjs1218@naver.com'  and rturn_due_date <curdate() and overdue_cdt =1 and rturn_date = curdate() 
	group by rturn_date;
	

select mber_name,od_cnt from member where mber_id = 'xodnjs1218@naver.com';
update member set od_cnt = 1 where mber_id = 'xodnjs1218@naver.com';
	
select *
			from lending
			where mber_id = 'xodnjs1218@naver.com' and rturn_date is null;
			
select rturn_date 
			from lending
			where mber_id = 'xodnjs1218@naver.com' and book_cd = '0601.001-1';
			
		
select *
	from librarian l ;
	

select DATEDIFF(curdate() , date_format('2020-02-04', "%Y-%m-%d"));
select DATEDIFF(curdate() , date_format('2020-03-30', "%Y-%m-%d"));
select DATEDIFF(date_format('2020-02-04', "%Y-%m-%d"), curdate() );
update member m join lending l on m.mber_id = l.mber_id set od_cnt = ? where m.mber_id = ? and where DATEDIFF(l.rturn_date, l.rturn_due_date ) > 0;
update member m join lending l on m.mber_id = l.mber_id set od_cnt = ? where m.mber_id = ? and DATEDIFF(l.rturn_date, l.rturn_due_date ) > 0;
select * from member m join lending l on m.mber_id = l.mber_id where l.overdue_cdt =0;




select *
	from lending l 
	where mber_id = 'xodnjs1218@naver.com';

select *
	from lending
select m.mber_name , l.rturn_date , l.rturn_due_date , l.book_cd ,l.overdue_cdt 
	from lending l join `member` m on l.mber_id = m.mber_id
	where m.mber_name ='조조';
	
select *
	from `member` m 
	where m.mber_name ='조조';
	





select *
	from librarian l ;




select * 
	from lending
	where mber_id = 'ku23324@naver.com' and book_cd = '0901.030-1';

update lending
	set rturn_date = curdate()
	where mber_id = 'ku23324@naver.com' and book_cd = '0901.030-1';

update lending 
	set overdue_cdt = 1
	where mber_id = 'ku23324@naver.com' and book_cd = '0901.030-1' and DATEDIFF(rturn_date, rturn_due_date)>0;


select *
	from member
	where mber_id = 'ku23324@naver.com';

update member
	set lend_psb_cdt = 1
	where mber_id = 'ku23324@naver.com' and od_cnt >4;

update member
	set lend_book_cnt







-- 반납 프로시저 테스트(회원 아이디, 도서코드)
drop procedure if exists return_book;

delimiter $$
$$
create procedure return_book(in _mber_id varchar(30), in _book_cd char(7))

begin
	declare cnt int;
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
		-- 연체도서의 갯수를 카운트 후 변수에 입력
		select count(*) into cnt 
			from lending
			where overdue_cdt = 1 and mber_id = 'xodnjs1218@naver.com';
		-- 연체 도서 카운팅한 수를 연체횟수에 입력
		update member
			set od_cnt = cnt
			where mber_id = _mber_id; 
		-- 회원 테이블의 연체횟수가 5회 이상일시 대여가능여부를 업데이트 
		update member
			set lend_psb_cdt = 1
			where od_cnt>4;
	commit;
	set AUTOCOMMIT = 1;
end $$

delimiter ;


update member m left join lending l
	on m.mber_id = l.mber_id
	set od_cnt = od_cnt +1
	where l.rturn_date = curdate() and l.overdue_cdt = 1 and m.mber_id = _mber_id and l.book_cd = _book_cd; 

select od_cnt
	from lending
	where overdue_cdt = 1 and mber_id = mber_id = 'ku23324@naver.com' and book_cd = '0901.030-1';






































-- 반납 프로시저 테스트(회원 아이디, 도서 코드)
drop procedure if exists update_lending_return_date_overdue_cdt;

delimiter $$
$$
create procedure update_lending_return_date_overdue_cdt(in _mber_id varchar(30), in _book_cd varchar(20))

begin
	declare continue handler for sqlexception
	begin
		select '오류 발생했습니다.';
		rollback;
	end;
	set AUTOCOMMIT = 0;
	start transaction;
		-- 대여반납 테이블
		-- 반납일 수정 쿼리문(특정 회원의 특정 도서 반납일을 오늘로 수정)
		update lending
		 set rturn_date = curdate()
		 where mber_id = _mber_id and book_cd = _book_cd;
		-- 반납일과 반납예정일의 차이가 0이상 일시 연체 여부를 연체로 수정
		update lending
		set overdue_cdt = 1
		where mber_id = _mber_id and book_cd = _book_cd and DATEDIFF(rturn_date , rturn_due_date) > 0;
	commit;
	set AUTOCOMMIT = 1;
end $$

delimiter ;








-- 반납 프로시저 테스트2(회원 아이디, 도서 코드)
drop procedure if exists update_lending_lend_psb_cdt_lend_book_cnt_book_lend_psb_cdt;

delimiter $$
$$
create procedure update_lending_lend_psb_cdt_lend_book_cnt_book_lend_psb_cdt(in _mber_id varchar(30), in _book_cd varchar(20))

begin
	declare cnt int;
	declare continue handler for sqlexception
	begin
		select '오류 발생했습니다.';
		rollback;
	end;
	set AUTOCOMMIT = 0;
	start transaction;
		-- 회원 테이블
		-- 특정 회원의 대여가능 여부를 연체횟수에 따라 수정
		update member
			set lend_psb_cdt =1
			where mber_id = _mber_id and od_cnt >4;
		-- 특정 회원의 반납되지 않은 도서의 갯수를 변수에 담음
		select count(*) into cnt
			from lending
			where mber_id = _mber_id and rturn_date is null;
		-- 담은 변수의 값을 특정 회원의 대여가능 권수의 값으로 넣음
		update member
			set lend_book_cnt = cnt
			where mber_id = _mber_id;
		-- 도서 테이블
		-- 도서의 대여 가능 여부를 수정
		update book b join lending l
			on b.book_code = l.book_cd
			set lend_psb_cdt = 0
			where l.rturn_date is not null;
	commit;
	set AUTOCOMMIT = 1;
end $$

delimiter ;