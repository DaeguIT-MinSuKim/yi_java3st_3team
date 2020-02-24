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