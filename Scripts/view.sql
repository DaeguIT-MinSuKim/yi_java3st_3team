-- 도서 전체 검색 view
DROP VIEW IF EXISTS vw_book;
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
DROP VIEW IF EXISTS vw_request_book;
create view vw_request_book as 
select reqst_book_no , rb1.reqst_book_name , reqst_book_author , reqst_book_trnslr , request_book_pls , 
	reqst_mb_id , reqst_date , wh_cdt , rb2.cnt
	from request_book rb1, 
		(select reqst_book_name , count(*) as cnt from request_book group by reqst_book_name) rb2
	where rb1.reqst_book_name = rb2.reqst_book_name;