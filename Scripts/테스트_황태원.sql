select user(), database ();

select *
from librarian;

select *
from zip_code;


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

select *
from member;

delete
from `member`
where mber_id = 'xodnjs1218';

insert into member(mber_id, mber_pass, mber_name, mber_brthdy, mber_zip, mber_bass_ad, mber_detail_ad, mber_tel, mber_img, join_dt) values
('bus503@daum.net', 'xodnjs', '황태원', '1991-12-18', 42457, '대구광역시 북구 태전로', null, '010-4245-3825', null, '2020-03-12');


select zip_code,ctprvn,signgu,road_name,buld_no_origin_no,buld_no_vice_no 
from zip_code
where ctprvn ='경상북도' and signgu='경산시' and road_name = '압독로' and buld_no_origin_no = 140 and buld_no_vice_no = 11;

select *
from zip_code;

select *
from member;




