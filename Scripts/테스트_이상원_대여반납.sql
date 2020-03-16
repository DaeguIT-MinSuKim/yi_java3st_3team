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