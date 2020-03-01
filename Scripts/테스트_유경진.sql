select user(), database();

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
		  
		 
		 
-- book
select * from book;
select book_code , book_name , authr_name , trnslr_name , pls , pblicte_year ,
	   book_price , lend_psb_cdt , total_le_cnt , book_img , lc_no, ml_no ,
	   regist_date , dsuse_cdt 
	from book;

select book_code , book_name , authr_name , trnslr_name , pls , pblicte_year ,
	   book_price , lend_psb_cdt , total_le_cnt , book_img , lc_no, ml_no ,
	   regist_date , dsuse_cdt 
	from book
	where book_code = 'A090101';

select book_code , book_name , authr_name , trnslr_name , pls , pblicte_year ,
	   book_price , lend_psb_cdt , total_le_cnt , book_img , lc_no, ml_no ,
	   regist_date , dsuse_cdt 
	from book
	where book_name = '천년의 질문';

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
	where book_code = 'D090101';
		 

-- 출판사
select * from publishing_company;
select pls_no , pls_name from publishing_company;
select pls_no , pls_name from publishing_company where pls_no = 1;

insert into publishing_company values(69, '테스트');
update publishing_company set pls_name = '테스트출판사' where pls_no = 69;
delete from publishing_company where pls_no = 69;


-- 대분류
select * from large_classification;
select lclas_no , lclas_name from large_classification;
select lclas_no , lclas_name from large_classification where lclas_no = 5;

insert into large_classification values (11, '테스트');
update large_classification set lclas_name = '테스트대분류' where lclas_no = 11;
delete from large_classification where lclas_no = 11;

-- 중분류
select * from middle_classification;
select lclas_no , mlsfc_no , mlsfc_name from middle_classification;
select lclas_no , mlsfc_no , mlsfc_name from middle_classification where lclas_no = 6 and mlsfc_no = 1;

insert into middle_classification values(10, 3, '테스트분류');
update middle_classification set mlsfc_name = '테스트중분류' where lclas_no = 10 and mlsfc_no = 3;
delete from middle_classification where lclas_no = 10 and mlsfc_no = 3;

-- 추천도서
select * from book;
select * from recommendation;
select r.book_code, book_cont 
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
insert into recommendation(book_code, book_cont) values ('A090102', '도서소개 테스트2....!!!');

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


-- 신청도서
select * from request_book;

select reqst_book_no , reqst_book_name , reqst_book_author , reqst_book_trnslr , request_book_pls , 
	reqst_mb_id , reqst_date , wh_cdt 
	from request_book
	where year(reqst_date) = '2020' and month(reqst_date) = '2';

select reqst_book_no , reqst_book_name , reqst_book_author , reqst_book_trnslr , request_book_pls , 
	reqst_mb_id , reqst_date , wh_cdt 
	from request_book
	where reqst_mb_id = 'ggg243r4@gmail.com';

insert into request_book(reqst_book_name, reqst_book_author, reqst_book_trnslr, request_book_pls, reqst_mb_id, reqst_date, wh_cdt)
	values ('Java의 정석', '남궁성', '', '도우출판', 'ggg243r4@gmail.com', '2020-02-29', 0);

update request_book 
	set reqst_mb_id = 'ggg243r4@gmail.com', reqst_book_name = '이것이 자바다', reqst_book_author = '신용권', reqst_book_trnslr = '', 
		request_book_pls = '한빛미디어', reqst_date = '2020-02-29', wh_cdt = 0
	where reqst_book_no = 11;

delete from request_book where reqst_book_no = 11;

-- 컬럼값 초기화
alter table request_book auto_increment = 11;







