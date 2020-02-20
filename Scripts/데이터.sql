select user(), database ();

-- member 회원
desc member;
load data local infile 'D:/workspace/workspace-teamProject/yi_java3st_3team/document/data/member.txt'
into table yi_java3st_3team.member 
character set 'utf8'
fields terminated by ',';

-- grade 회원등급

-- request_book 신청도서
 
-- lending 대여/반납

-- book 도서

-- publishing_company 출판사
desc publishing_company;
load data local infile 'D:/workspace/workspace-teamProject/yi_java3st_3team/document/data/pls_data.csv'
into table yi_java3st_3team.librarian 
character set 'utf8'
fields terminated by ','
ignore 1 lines;

-- recommendation 추천도서

-- large_classification 대분류

-- middle_classification 중분류

-- librarian 사서
desc librarian;
load data local infile 'D:/workspace/workspace-teamProject/yi_java3st_3team/document/data/librarian.txt'
into table yi_java3st_3team.librarian 
character set 'utf8'
fields terminated by ',';

-- title 직책
desc title;
insert into title values
(1,'총관리자'),
(2,'사서'),
(3,'회원');

-- zip_code 우편번호

