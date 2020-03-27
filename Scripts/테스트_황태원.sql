select user(), database ();

select *
from librarian;

select lb_id, lb_pass, lb_name ,lb_birthday ,lb_zip ,lb_bass_ad ,lb_detail_ad ,lb_tel ,title ,join_date ,work_cdt 
from librarian
where lb_id = 'iiopio5@book.ff.kr';


select lb_id, lb_pass, lb_name ,lb_birthday ,lb_zip ,lb_bass_ad ,lb_detail_ad ,lb_tel, lb_img ,title ,join_date ,work_cdt
from librarian;

select lb_pass, lb_name, lb_birthday, lb_zip, lb_bass_ad, lb_detail_ad, lb_tel, lb_img, title, 
join_date, work_cdt
from librarian where lb_id ='iiopio5@book.ff.kr';

select lb_id, lb_pass, lb_name, lb_birthday, lb_zip, lb_bass_ad, lb_detail_ad, lb_tel, lb_img, title, join_date, work_cdt from librarian where lb_id = 'iiopio5@book.ff.kr';

select *
from librarian;

delete
from librarian 
where lb_id ='hwangbug@book.ff.kr';

update librarian 
set lb_id =''

insert into librarian values
('hwangbug@book.ff.kr', 'bug', '황충', '1920-10-12', 42457, '대구광역시 북구 태전로', null, '010-4432-4141', null, 0, '2020-02-10', 0);



select mber_id, mber_pass, mber_name, mber_brthdy, mber_zip, mber_bass_ad, mber_detail_ad, mber_tel, mber_img, total_le_cnt, lend_book_cnt, grade, lend_psb_cdt, join_dt, wdr_cdt from member where mber_id = 'ddongtree@naver.com';

updete member
set 
where mber_id;

delete
from `member`
where mber_id = 'bus503@daum.net';

select *
from member;

select mber_id, mber_name, mber_brthdy, mber_bass_ad, mber_detail_ad, mber_tel, total_le_cnt, lend_book_cnt, grade, join_dt , wdr_cdt
from member;

select b1.book_code , b1.book_name, b1.authr_name , b1.trnslr_name , b1.pls, p.pls_name , b1.pblicte_year , 
	   b1.book_price , b2.book_cnt, b1.lend_psb_cdt , b1.total_le_cnt , b1.book_img , b1.lc_no, l.lclas_name , b1.ml_no , m.mlsfc_name , 
	   b1.regist_date , b1.dsuse_cdt
from book b1 
	left join publishing_company p on b1.pls = p.pls_no left join large_classification l on b1.lc_no = l.lclas_no 
	left join middle_classification m on m.mlsfc_no = b1.ml_no and l.lclas_no = m.lclas_no, 
	(select book_name, authr_name , pls, pblicte_year , book_price , count(*) as book_cnt from book group by book_name, authr_name , pls, pblicte_year , book_price) b2 
where b1.book_name = b2.book_name and b1.authr_name = b2.authr_name and b1.pls = b2.pls and b1.pblicte_year = b2.pblicte_year and b1.book_price = b2.book_price 
order by b1.regist_date;

select *
from member;

select mber_id, mber_name, mber_brthdy, mber_bass_ad, mber_detail_ad, mber_tel, total_le_cnt, lend_book_cnt, grade, join_dt , wdr_cdt, lend_psb_cdt, od_cnt 
from member;

select grad_name 
from grade;

select *
from grade;

select grad_name from grade;


select *
from member;

delete from member where mber_id='daddystop@gmail.com';

delete from member 
where mber_name ='이전';

select mber_id, mber_name, mber_brthdy, mber_zip, mber_bass_ad, mber_detail_ad, mber_tel, mber_img, total_le_cnt, lend_book_cnt, grade, join_dt , wdr_cdt, lend_psb_cdt, od_cnt
from member;

select mber_id, mber_name, mber_brthdy, mber_zip, mber_bass_ad, mber_detail_ad, mber_tel, mber_img, total_le_cnt, lend_book_cnt, grade, join_dt , wdr_cdt, lend_psb_cdt, od_cnt
from member
where date(mber_brthdy) = '2020-03-16';


select *
from member;

select mber_id, mber_name, mber_brthdy, mber_zip, mber_bass_ad, mber_detail_ad, mber_tel, mber_img, total_le_cnt, lend_book_cnt, grade, join_dt , wdr_cdt, lend_psb_cdt, od_cnt
from member
where mber_name like '%하후%';

select mber_id, mber_name


select mber_id, mber_name, mber_brthdy, mber_zip, mber_bass_ad, mber_detail_ad, mber_tel, mber_img, total_le_cnt, lend_book_cnt, grade, join_dt , wdr_cdt, lend_psb_cdt, od_cnt 
from member 
where date(mber_brthdy) like '%2020%';

select *
from book;

select *
from member;

select*
from grade;

select title_name from title;
select *
from title;

select lb_id, lb_pass, lb_name, lb_birthday, lb_zip, lb_bass_ad, lb_detail_ad, lb_tel, lb_img, title, join_date, work_cdt
from librarian;

select lb_id, lb_pass, lb_name, lb_birthday, lb_zip, lb_bass_ad, lb_detail_ad, lb_tel, lb_img, title, join_date, work_cdt  
from librarian
where lb_id like '%eiwre%';

select *
from librarian;

select title_name from title;

select *
from title;

delete
from librarian 
where lb_id ='테스트';

insert into librarian(lb_id, lb_pass, lb_name, lb_birthday, lb_zip, lb_bass_ad, lb_detail_ad, lb_tel, lb_img, title ,join_date ,work_cdt) values
('테스트', '테스트', '황태원',null,null,null,null,null,null,0,'1991-12-18',0);

select work_cdt 
from librarian
where lb_id='43ojlkjl@book.ff.kr';

select *
from member;

select *
from book;

select m.mber_name , count(*) 
	from lending l left join `member` m on l.mber_id = m.mber_id
	group by l.mber_id;

select *
from lending;

insert into lending(mber_id, book_cd , lend_date , rturn_due_date ,rturn_psm_cdt , rturn_date ,overdue_cdt ) values
('bus503@daum.net', '0201.001-1', '2018-10-15','2018-10-30', 1, null,0 );




