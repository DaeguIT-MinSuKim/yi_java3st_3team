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
	from `member`;
