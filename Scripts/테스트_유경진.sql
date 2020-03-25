select user(), database();

select book_code, book_name, authr_name, trnslr_name, pls, pls_name, pblicte_year, book_price,b.lend_psb_cdt , b.total_le_cnt, book_img, lc_no, ml_no, lend_date, rturn_date, rturn_due_date, od_cnt 
	from lending l left join book b on l.book_cd = b.book_code left join publishing_company p on b.pls = p.pls_no left join member m on l.mber_id = m.mber_id 
	where l.mber_id = 'ddr23dd@naver.com' and rturn_date is null;

-- 탈퇴회원 테스트 용 데이터 변경
--update `member` 
--	set wdr_cdt = 1
--	where mber_id = 'daddystop@gmail.com';

-- login 테스트
select * from `member`;
select mber_id , mber_pass, mber_name, mber_brthdy , mber_zip , mber_bass_ad ,
	   mber_detail_ad , mber_tel , mber_img, total_le_cnt , lend_book_cnt , 
	   grade , lend_psb_cdt , join_dt , wdr_cdt 
	from member 
	where mber_id = "daddystop@gmail.com" and mber_pass = "airopwieop3678";
	
select * from librarian;
select lb_id, lb_pass, lb_name, lb_birthday, lb_zip, lb_bass_ad, lb_detail_ad, 
       lb_tel, lb_img, title, join_date, work_cdt
	from librarian
	where lb_id = '43ojlkjl@book.ff.kr' and lb_pass = 'fjgfkdlj6';
	
-- findId 테스트
select mber_id , mber_pass, mber_name, mber_brthdy , mber_zip , mber_bass_ad , 
       mber_detail_ad , mber_tel , total_le_cnt , lend_book_cnt , grade , 
       lend_psb_cdt , join_dt , wdr_cdt 
	from member 
	where mber_name = '이전' and mber_brthdy = '1984-08-04';

select lb_id, lb_pass, lb_name, lb_birthday, lb_zip, lb_bass_ad, lb_detail_ad,
	   lb_tel, lb_img, title, join_date, work_cdt
	from librarian
	where lb_name = '원소' and lb_birthday = '1961-12-31';
	
-- findPw 테스트
select mber_id , mber_pass, mber_name, mber_brthdy , mber_zip , mber_bass_ad ,
	   mber_detail_ad , mber_tel , total_le_cnt , lend_book_cnt , grade ,
	   lend_psb_cdt , join_dt , wdr_cdt 
	from member 
	where mber_id  = 'daddystop@gmail.com' and mber_name = '이전' 
		  and mber_brthdy = '1984-08-04';
	
select lb_id, lb_pass, lb_name, lb_birthday, lb_zip, lb_bass_ad, lb_detail_ad,
	   lb_tel, lb_img, title, join_date, work_cdt
	from librarian
	where lb_id = '43ojlkjl@book.ff.kr' and lb_name = '원소' 
		  and lb_birthday = '1961-12-31';
		  
-- book -------------------------------------------------------------------------------
select * from book where pls = 196;
select * from book;
select * from book where book_name = '82년생 김지영';

-- 각 도서의 마지막 코드를 가져오는 테스트용 데이터
insert into book(book_code , book_name , authr_name , pls, pblicte_year , book_price , lc_no , ml_no , regist_date , lend_psb_cdt ) values 
('0901.001-2', '82년생 김지영', '조남주', 1, '2016-10-14', 13000, 9, 1, '2020-03-20', 0);

-- 특정 책의 마지막 코드 / 분류의 마지막 코드
select book_code from book where book_name = '82년생 김지영' and authr_name = '조남주' and pls = '1' order by regist_date desc limit 1 ;
select book_code from book where lc_no = 09 and ml_no = 01 order by book_code desc limit 1;


select book_code , book_name , authr_name , trnslr_name , pls , pblicte_year ,
	   book_price , lend_psb_cdt , total_le_cnt , book_img , lc_no, ml_no ,
	   regist_date , dsuse_cdt 
	from book
	order by regist_date;

-- 도서 권수 카운터
select book_name, count(*) as cnt
	from book
	group by book_name, authr_name , pls, pblicte_year , book_price
	order by book_code;

-- 보유권수 테스트로 중복 도서 추가
-- delete from book where book_code = 'D100201';
-- insert into book values ('D100201', '북유럽 이야기', '김민주', '', 196, '2014-01-27', 14000, 0, 0, '', 10, 2, '2020-03-04', 0);
 

-- 도서검색
-- all 
select b1.book_code , b1.book_name, b1.authr_name , b1.trnslr_name , b1.pls, p.pls_name , b1.pblicte_year ,
	   b1.book_price , b2.book_cnt, b1.lend_psb_cdt , b1.total_le_cnt , b1.book_img , b1.lc_no, l.lclas_name , b1.ml_no, m.mlsfc_name ,
	   b1.regist_date , b1.dsuse_cdt
	from book b1 
		left join publishing_company p on b1.pls = p.pls_no left join large_classification l on b1.lc_no = l.lclas_no 
		left join middle_classification m on m.mlsfc_no = b1.ml_no and l.lclas_no = m.lclas_no,
		(select book_name, authr_name , pls, pblicte_year , book_price , count(*) as book_cnt from book group by book_name, authr_name , pls, pblicte_year , book_price) b2
	where b1.book_name = b2.book_name and b1.authr_name = b2.authr_name and b1.pls = b2.pls and b1.pblicte_year = b2.pblicte_year and b1.book_price = b2.book_price
	order by b1.book_code ;

-- 도서코드 검색
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

select * from vw_book where book_code like '09%' and lc_no = 9;

select * from vw_book where book_code like '%09%'  

select b1.book_code , b1.book_name, b1.authr_name , b1.trnslr_name , b1.pls, p.pls_name , b1.pblicte_year ,
	   b1.book_price , b2.book_cnt, b1.lend_psb_cdt , b1.total_le_cnt , b1.book_img , b1.lc_no, l.lclas_name , b1.ml_no,
	   b1.regist_date , b1.dsuse_cdt
	from book b1 
		left join publishing_company p on b1.pls = p.pls_no left join large_classification l on b1.lc_no = l.lclas_no 
		left join middle_classification m on m.mlsfc_no = b1.ml_no and l.lclas_no = m.lclas_no,
		(select book_name, authr_name , pls, pblicte_year , book_price , count(*) as book_cnt from book group by book_name, authr_name , pls, pblicte_year , book_price) b2
	where b1.book_name = b2.book_name and b1.authr_name = b2.authr_name and b1.pls = b2.pls and b1.pblicte_year = b2.pblicte_year and 
			b1.book_price = b2.book_price and b1.book_code like 'C%' and b1.lc_no = 9
	order by b1.regist_date;
		
select count(*) from book where book_name like '82%' group by book_name;
-- 도서명 검색 
select b1.book_code , b1.book_name, b1.authr_name , b1.trnslr_name , b1.pls, p.pls_name , b1.pblicte_year ,
	   b1.book_price , b2.book_cnt, b1.lend_psb_cdt , b1.total_le_cnt , b1.book_img , b1.lc_no, l.lclas_name , b1.ml_no,
	   b1.regist_date , b1.dsuse_cdt
	from book b1 
		left join publishing_company p on b1.pls = p.pls_no left join large_classification l on b1.lc_no = l.lclas_no 
		left join middle_classification m on m.mlsfc_no = b1.ml_no and l.lclas_no = m.lclas_no,
		(select book_name, authr_name , pls, pblicte_year , book_price , count(*) as book_cnt from book group by book_name, authr_name , pls, pblicte_year , book_price) b2
	where b1.book_name = b2.book_name and b1.authr_name = b2.authr_name and b1.pls = b2.pls and b1.pblicte_year = b2.pblicte_year and 
			b1.book_price = b2.book_price and b1.book_name like '%북%' and b1.lc_no = 6
	order by b1.regist_date;

		
-- 도서검색 (회원)
-- all
select b1.book_code , b1.book_name, b1.authr_name , b1.trnslr_name , b1.pls, p.pls_name , b1.pblicte_year ,
	   b1.book_price , b2.book_cnt, b1.lend_psb_cdt , b1.total_le_cnt , b1.book_img , b1.lc_no, l.lclas_name , b1.ml_no, m.mlsfc_name,
	   b1.regist_date , b1.dsuse_cdt
	from book b1 
		left join publishing_company p on b1.pls = p.pls_no left join large_classification l on b1.lc_no = l.lclas_no 
		left join middle_classification m on m.mlsfc_no = b1.ml_no and l.lclas_no = m.lclas_no,
		(select book_name, authr_name , pls, pblicte_year , book_price , count(*) as book_cnt from book group by book_name, authr_name , pls, pblicte_year , book_price) b2
	where b1.book_name = b2.book_name and b1.authr_name = b2.authr_name and b1.pls = b2.pls and b1.pblicte_year = b2.pblicte_year and 
			b1.book_price = b2.book_price
	order by b1.book_name;

-- search
select b1.book_code , b1.book_name, b1.authr_name , b1.trnslr_name , b1.pls, p.pls_name , b1.pblicte_year ,
	   b1.book_price , b2.book_cnt, b1.lend_psb_cdt , b1.total_le_cnt , b1.book_img , b1.lc_no, l.lclas_name , b1.ml_no, m.mlsfc_name,
	   b1.regist_date , b1.dsuse_cdt
	from book b1 
		left join publishing_company p on b1.pls = p.pls_no left join large_classification l on b1.lc_no = l.lclas_no 
		left join middle_classification m on m.mlsfc_no = b1.ml_no and l.lclas_no = m.lclas_no,
		(select book_name, authr_name , pls, pblicte_year , book_price , count(*) as book_cnt from book group by book_name, authr_name , pls, pblicte_year , book_price) b2
	where b1.book_name = b2.book_name and b1.authr_name = b2.authr_name and b1.pls = b2.pls and b1.pblicte_year = b2.pblicte_year and 
			b1.book_price = b2.book_price and b1.book_name like '%북유럽%' and b1.authr_name like '김%' and b1.lc_no = 10
	order by b1.book_name;

select book_name, authr_name , pls, pblicte_year , book_price , count(*) as book_cnt from book group by book_name, authr_name , pls, pblicte_year , book_price;
select * from book;
select * from large_classification;

insert into book(book_code , book_name , authr_name , trnslr_name , pls , 
				 pblicte_year , book_price , lend_psb_cdt , total_le_cnt ,
				 book_img , lc_no , ml_no , regist_date , dsuse_cdt ) values
('D090101', '먼 바다', '공지영', '', 2, '2020-02-17', 15800, 0, 0, '', 09, 01, 
'2020-02-24', 0);

update book 
	set book_name = '먼 바다', authr_name = '공지영', trnslr_name = '', pls = '2', 
		pblicte_year = '2020-02-17', book_price = 15800, lend_psb_cdt = 0, 
		total_le_cnt = 5, book_img = '', lc_no = 09, ml_no = 01, 
		regist_date ='2020-02-19', dsuse_cdt = 0
	where book_code = 'D090101';
		
delete 
	from book 
	where book_code = 'D030104';

-- 출판사
select * from publishing_company;
select pls_no , pls_name from publishing_company order by pls_name;
select pls_no , pls_name from publishing_company where pls_no = 1;
select max(pls_no) from publishing_company;

select pls_no, pls_name from publishing_company where pls_name like '창%';

insert into publishing_company values(69, '테스트');
update publishing_company set pls_name = '테스트출판사' where pls_no = 69;
delete from publishing_company where pls_no = 69;


-- 대분류
select * from large_classification;
select lclas_no , lclas_name from large_classification;
select lclas_no , lclas_name from large_classification where lclas_no = 5;
select max(lclas_no) from large_classification;

insert into large_classification values (11, '테스트');
update large_classification set lclas_name = '테스트대분류' where lclas_no = 11;
delete from large_classification where lclas_no = 11;

-- 중분류
select * from middle_classification;
select lc.lclas_no , lc.lclas_name , ml.mlsfc_no , ml.mlsfc_name from middle_classification ml left join large_classification lc on ml.lclas_no = lc.lclas_no ;
select lc.lclas_no , lc.lclas_name , ml.mlsfc_no , ml.mlsfc_name 
	from middle_classification ml left join large_classification lc on ml.lclas_no = lc.lclas_no 
	where ml.mlsfc_no = 1 and ml.mlsfc_name = 'test';
select lclas_no , mlsfc_no , mlsfc_name from middle_classification where lclas_no = 6 and mlsfc_no = 1;
select max(mlsfc_no) from middle_classification where lclas_no = 2;
select max(mlsfc_no) from middle_classification where lclas_no = 2

insert into middle_classification values(10, 3, '테스트분류');
update middle_classification set mlsfc_name = '테스트중분류' where lclas_no = 10 and mlsfc_no = 3;
delete from middle_classification where lclas_no = 10 and mlsfc_no = 3;
select * from middle_classification;
select * from middle_classification where mlsfc_no = 1 and mlsfc_name = 'test';

-- 추천도서 ----------------------------------------------------------------------------------------------------------------
select * from book;
select * from recommendation;
select book_code, book_cont 
	from recommendation
	order by recom_book_no desc limit 1;


select r.recom_book_no , r.book_code , r.book_cont , lc.lclas_no , lc.lclas_name , ml.mlsfc_no , ml.mlsfc_name ,
	  	b.authr_name , b.trnslr_name , b.book_name , pls.pls_no , pls.pls_name , b.book_img, b.pblicte_year 
	from recommendation r join book b on b.book_code = r.book_code  
				join large_classification lc on b.lc_no = lc.lclas_no 
				join middle_classification ml on b.ml_no = ml.mlsfc_no and b.lc_no = ml.lclas_no 
				join publishing_company pls on b.pls = pls.pls_no 
	order by r.recom_book_no desc limit 1;

select r.book_code, lc.lclas_name as '대분류', ml.mlsfc_name as '중분류', b.authr_name as '작가', b.trnslr_name as '역자',
	   b.book_name as '도서명', pls.pls_name as '출판사', b.book_img as '도서이미지', r.book_cont as '줄거리'
	from recommendation r join book b on b.book_code = r.book_code  
				join large_classification lc on b.lc_no = lc.lclas_no 
				join middle_classification ml on b.ml_no = ml.mlsfc_no and b.lc_no = ml.lclas_no 
				join publishing_company pls on b.pls = pls.pls_no 
	where r.book_code = 'A090101';

insert into recommendation(book_code, book_cont) values ('A090101', '도서소개 테스트....!!!');
insert into recommendation(book_code, book_cont) values ('D090101', '도서소개 테스트2....!!!');

select * from recommendation;
insert into recommendation(book_code, book_cont) values ('A090103', '도서소개 테스트3....!!!');
update recommendation set book_cont = '[수정]도서소개 테스트3' where book_code = 'A090103';
delete from recommendation where book_code = 'A090103';

select count(*)+1 from recommendation;

--  추천도서 도서번호 재정렬
set @cnt = 0;
update recommendation set recommendation.recom_book_no = @cnt:=@cnt+1;

-- 컬럼값 초기화
alter table recommendation auto_increment = 3;


-- 회원 이용 현황 ---------------------------------------------------------------------
select * from `member` where mber_id = 'fivestar@nate.com';

-- 도서 이용 현황
select mber_id, mber_name, grade, lend_book_cnt, total_le_cnt from `member` where mber_id = 'fivestar@nate.com';		

-- 대여/반납 데이터 반영 업데이트
update `member` 
	set lend_book_cnt = 2, total_le_cnt = 4
	where mber_id = 'fivestar@nate.com';

select * 
from lending 
where mber_id = 'fivestar@nate.com' and rturn_date = 00-00-00
union 
select * 
from lending
where mber_id = 'fivestar@nate.com' and rturn_date is null;


-- 전체 대여 도서
select l.mber_id , b.book_code , b.book_name , b.lc_no , lc.lclas_name , b.ml_no , ml.mlsfc_name , b.pls, pls.pls_name , b.pblicte_year ,
	   lend_date , rturn_due_date, rturn_psm_cdt, rturn_date, overdue_cdt
	from lending l left join book b on l.book_cd = b.book_code 
				   left join large_classification lc on lc.lclas_no = b.lc_no 
				   left join middle_classification ml on ml.mlsfc_no = b.ml_no and lc.lclas_no = ml.lclas_no
				   left join publishing_company pls on pls.pls_no = b.pls 
	where mber_id = 'fivestar@nate.com';

-- 대여 중 도서
-- select l.mber_id , l.book_cd, b.book_name , b.lc_no , lc.lclas_name , b.ml_no , ml.mlsfc_name , b.pls, pls.pls_name , b.pblicte_year ,
-- 	   lend_date , rturn_due_date, rturn_psm_cdt, rturn_date, overdue_cdt, overdue_date
-- 	from lending l left join book b on l.book_cd = b.book_code 
-- 				   left join large_classification lc on lc.lclas_no = b.lc_no 
-- 				   left join middle_classification ml on ml.mlsfc_no = b.ml_no and lc.lclas_no = ml.lclas_no
-- 				   left join publishing_company pls on pls.pls_no = b.pls 
-- 	where mber_id = 'fivestar@nate.com' and rturn_date = 00-00-00
-- union 
select l.mber_id , l.book_cd, b.book_name , b.lc_no , lc.lclas_name , b.ml_no , ml.mlsfc_name , b.pls, pls.pls_name , b.pblicte_year ,
	   lend_date , rturn_due_date, rturn_psm_cdt, rturn_date, overdue_cdt
	from lending l left join book b on l.book_cd = b.book_code 
				   left join large_classification lc on lc.lclas_no = b.lc_no 
				   left join middle_classification ml on ml.mlsfc_no = b.ml_no and lc.lclas_no = ml.lclas_no
				   left join publishing_company pls on pls.pls_no = b.pls 
	where mber_id = 'fivestar@nate.com' and rturn_date is null;


select * from lending where rturn_date = 00-00-00;
select * from lending where rturn_date <=> null;

select * from lending;

select length(rturn_date) from lending;
		
-- null 값 인식 테스트
insert into lending(mber_id, book_cd, lend_date, rturn_due_date, rturn_psm_cdt, overdue_cdt, overdue_date) values
('fivestar@nate.com', 'A090101', '2020-03-12', '2020-03-27', 0, 0, 0);

select * from lending where rturn_date is null;

select * from lending where book_cd = 'A090253' and mber_id = 'fivestar@nate.com' and rturn_date is null;

select * from lending where mber_id = 'fivestar@nate.com' and rturn_date is null; 
select * from lending where book_cd = 'A090253' and mber_id = 'fivestar@nate.com' and rturn_date is null; 

update lending 
	set rturn_psm_cdt = 0
	where mber_id = 'fivestar@nate.com' and rturn_date is null;

-- 대여권수 카운트
select count(*) from lending where mber_id = 'daddystop@gmail.com' and rturn_date is null; 
select count(*) from lending where mber_id = 'ya2354fr@yahoo.com'; 

select * from lending where mber_id = 'daddystop@gmail.com'; 
update lending 
	set rturn_psm_cdt = 0
	where mber_id = 'daddystop@gmail.com' and rturn_date is null;
		

-- 대여순위/신착도서리스트 -----------------------------------------------------------------------------------------------------
-- 총 대여 카운트 / 총 대여 카운트 순위 5개
select l1.book_cd , b.book_name, b.book_img , b.authr_name , b.trnslr_name , b.lc_no , lc.lclas_name , b.ml_no , ml.mlsfc_name , 
		b.pls , p.pls_name ,l2.totlaCnt
	from lending l1 left join book b on l1.book_cd = b.book_code 
					left join large_classification lc on b.lc_no = lc.lclas_no 
					left join middle_classification ml on b.ml_no = ml.mlsfc_no and lc.lclas_no = ml.lclas_no
					left join publishing_company p on b.pls = p.pls_no ,
		(select book_cd , count(*) as totlaCnt from lending group by book_cd) l2
	where l1.book_cd = l2.book_cd
	group by l1.book_cd
	order by l2.totlaCnt desc limit 5;

-- 대여중인 도서
select l1.book_cd , b.book_name , l1.rturn_date , l2.lendCnt
	from lending l1 left join book b on l1.book_cd = b.book_code,
		(select book_cd , count(*) as lendCnt from lending where rturn_date is null group by book_cd) l2
	where l1.book_cd = l2.book_cd and l1.rturn_date is null;

-- 신착도서 
select pblicte_year, book_name , book_img , authr_name , trnslr_name , b.lc_no , l.lclas_name , b.ml_no , m.mlsfc_name , b.pls , p.pls_name , b.pblicte_year 
	from book b left join large_classification l on b.lc_no = l.lclas_no 
				left join middle_classification m on b.ml_no = m.mlsfc_no and l.lclas_no = m.lclas_no 
				left join publishing_company p on b.pls = p.pls_no 
	group by book_name
	order by pblicte_year desc limit 5;

select * from book;


-- 신청도서 ---------------------------------------------------------------------------------------------------
select * from request_book;
select count(*) from request_book group by reqst_book_name;

select * from book;
-- 신청 전 도서 검색
select b.book_name , b.authr_name , b.trnslr_name , pls.pls_name 
	from book b left join publishing_company pls on b.pls = pls.pls_no 
	where b.book_name = "마블 백과사전" and b.authr_name = "톰 드팔코" and b.trnslr_name like "이규원%" and pls.pls_name like '시공사%'
	group by b.book_name;

-- 전체 검색
select reqst_book_no , rb1.reqst_book_name , reqst_book_author , reqst_book_trnslr , request_book_pls , 
	reqst_mb_id , reqst_date , wh_cdt , rb2.cnt
	from request_book rb1, 
		(select reqst_book_name , count(*) as cnt from request_book group by reqst_book_name) rb2
	where rb1.reqst_book_name = rb2.reqst_book_name;

-- 전체 검색 (view)
create view vw_request_book as 
select reqst_book_no , rb1.reqst_book_name , reqst_book_author , reqst_book_trnslr , request_book_pls , 
	reqst_mb_id , reqst_date , wh_cdt , rb2.cnt
	from request_book rb1, 
		(select reqst_book_name , count(*) as cnt from request_book group by reqst_book_name) rb2
	where rb1.reqst_book_name = rb2.reqst_book_name;

-- 전체 검색
select reqst_book_no, reqst_book_name, reqst_book_author, reqst_book_trnslr, request_book_pls, reqst_mb_id, reqst_date, wh_cdt, cnt 
	from vw_request_book order by reqst_date ; 

-- 선택조건 모두 검색
select reqst_book_no, reqst_book_name, reqst_book_author, reqst_book_trnslr, request_book_pls, reqst_mb_id, reqst_date, wh_cdt, cnt
	from vw_request_book 
	where year(reqst_date) = 2020 and month(reqst_date) = 2 and wh_cdt = 0
	order by reqst_date ;

-- 년도조건, 입고조건 검색
select reqst_book_no, reqst_book_name, reqst_book_author, reqst_book_trnslr, request_book_pls, reqst_mb_id, reqst_date, wh_cdt, cnt
	from vw_request_book 
	where year(reqst_date) = 2020 and wh_cdt = 0
	order by reqst_date ;

-- 신청 id와 도서명 검색 (회원 페이지에서 나와야할 신청도서 리스트)
select reqst_book_no, reqst_book_name, reqst_book_author, reqst_book_trnslr, request_book_pls, reqst_mb_id, reqst_date, wh_cdt, cnt 
	from vw_request_book_member 
	where reqst_mb_id = 'ggg243r4@gmail.com'
	order by reqst_date ;

select reqst_book_no, reqst_book_name, reqst_book_author, reqst_book_trnslr, request_book_pls, reqst_mb_id, reqst_date, wh_cdt, cnt 
	from vw_request_book_member 
	where year(reqst_date) = '2020' and reqst_mb_id = 'ggg243r4@gmail.com'
	order by reqst_date;

-- 신청 도서 등록 (회원 페이지)
insert into request_book(reqst_book_name, reqst_book_author, reqst_book_trnslr, request_book_pls, reqst_mb_id, reqst_date, wh_cdt)
	values ('Java의 정석', '남궁성', '', '도우출판', 'ggg243r4@gmail.com', '2020-03-18', 0);

-- 입고 처리
update request_book 
	set wh_cdt = 1
	where reqst_book_name = 'Java의 정석' and request_book_pls = '도우출판';

delete from request_book where reqst_mb_id = '' and reqst_book_name = '';




-- 컬럼값 초기화
alter table request_book auto_increment = 11;

delete from request_book where reqst_book_name = 'Java의 정석';
-- delete from request_book where reqst_book_no = 13;
-- delete from request_book where reqst_book_no = 14;




		
select b1.book_code , b1.book_name, b1.authr_name , b1.trnslr_name , b1.pls, p.pls_name , b1.pblicte_year , 
	   b1.book_price , b2.book_cnt, b1.lend_psb_cdt , b1.total_le_cnt , b1.book_img , b1.lc_no, l.lclas_name , b1.ml_no, 
	   b1.regist_date , b1.dsuse_cdt 
	from book b1 
		left join publishing_company p on b1.pls = p.pls_no left join large_classification l on b1.lc_no = l.lclas_no 
		left join middle_classification m on m.mlsfc_no = b1.ml_no and l.lclas_no = m.lclas_no,
		(select book_name, authr_name , pls, pblicte_year , book_price , count(*) as book_cnt from book group by book_name, authr_name , pls, pblicte_year , book_price) b2 	where b1.book_name = b2.book_name and b1.authr_name = b2.authr_name and b1.pls = b2.pls and b1.pblicte_year = b2.pblicte_year and b1.book_price = b2.book_price and b1.book_code like '%D%' and b1.lc_no = 9  order by b1.regist_date


