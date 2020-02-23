select user(), database();

-- login 테스트
select * from `member`;
select mber_id , mber_pass, mber_name, mber_brthdy , mber_zip , mber_bass_ad , mber_detail_ad , mber_tel , mber_img, total_le_cnt ,
	   lend_book_cnt , grade , lend_psb_cdt , join_dt , wdr_cdt 
	from member 
	where mber_id = "daddystop@gmail.com" and mber_pass = "airopwieop3678";
	
select * from librarian;

select lb_id, lb_pass, lb_name, lb_birthday, lb_zip, lb_bass_ad, lb_detail_ad, lb_tel, lb_img, title, join_date, work_cdt
	from librarian
	where lb_id = '43ojlkjl@book.ff.kr' and lb_pass = 'fjgfkdlj6';
	
-- findId 테스트
select mber_id , mber_pass, mber_name, mber_brthdy , mber_zip , mber_bass_ad , mber_detail_ad , mber_tel , total_le_cnt ,
	   lend_book_cnt , grade , lend_psb_cdt , join_dt , wdr_cdt 
	from member 
	where mber_id = "daddystop@gmail.com" and mber_pass = "airopwieop3678";