select user(), database ();

desc lending;
select * from lending;

select m.mber_id , m.mber_name , g.grad_name , m.lend_psb_cdt , (g.book_le_cnt - count(l.rturn_date)) as 'lend_book_cdt'
	from member m left join lending l on m.mber_id = l.mber_id left join grade g on m.grade = g.grade_no 
	where m.mber_id = 'daddystop@gmail.com' and l.rturn_date = '0000-00-00 00:00:00';

