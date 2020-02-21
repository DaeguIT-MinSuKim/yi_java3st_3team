select user(), database ();

-- grade 회원등급
desc grade;
insert into grade values
(1,'일반',5),
(2,'우수',7);

-- member 회원
desc member;
load data local infile 'D:/workspace/workspace_teamProject/yi_java3st_3team/document/data/member.txt'
into table yi_java3st_3team.member
character set 'utf8'
fields terminated by ',';

-- request_book 신청도서
desc request_book; 

-- lending 대여/반납

-- book 도서
desc book;
load data local infile 'D:/workspace/workspace_teamProject/yi_java3st_3team/document/data/book_data.csv'
into table yi_java3st_3team.book 
character set 'utf8'
fields terminated by ','
ignore 1 lines;

-- publishing_company 출판사
desc publishing_company;
load data local infile 'D:/workspace/workspace_teamProject/yi_java3st_3team/document/data/pls_data.csv'
into table yi_java3st_3team.publishing_company
character set 'utf8'
fields terminated by ','
ignore 1 lines;

-- recommendation 추천도서

-- large_classification 대분류
desc large_classification;
insert into large_classification values
(01, '지식학문'),
(02, '철학'),
(03, '종교'),
(04, '사회과학'),
(05, '자연과학'),
(06, '기술과학'),
(07, '예술'),
(08, '언어'),
(09, '문학'),
(10, '역사');

-- middle_classification 중분류
desc middle_classification ;
insert into middle_classification values
(01, '신문', 01),
(02, '백과사전', 01),
(01, '동양철학', 02),
(02, '서양철학', 02),
(01, '비교종교', 03),
(02, '자연종교', 03),
(01, '통계학', 04),
(02, '정치학', 04),
(01, '생명과학', 05),
(02, '천문학', 05),
(01, '기계공학', 06),
(02, '환경공학', 06),
(01, '음악', 07),
(02, '공예', 07),
(01, '국어', 08),
(02, '기타언어', 08),
(01, '한국문학', 09),
(02, '영미문학', 09),
(01, '아시아', 10),
(02, '유럽', 10);

-- title 직책
desc title;
insert into title values
(1,'총관리자'),
(2,'사서'),
(3,'회원');

-- librarian 사서
desc librarian;
load data local infile 'D:/workspace/workspace_teamProject/yi_java3st_3team/document/data/librarian.txt'
into table yi_java3st_3team.librarian 
character set 'utf8'
fields terminated by ',';

-- zip_code 우편번호

