select user(), database();

show tables;

desc ban;
desc subject;
desc student;
desc score;

select * from ban;
insert into ban values ('A01'), ('A02'), ('B01');

select * from subject;
insert into subject values 
(1, '국어'), (2, '영어'), (3, '수학'), (4, '사회'), (5, '과학');

desc student;
select * from student;
insert into student values
(20001, '박재선', 1, 'A01', 20210302, null, null),
(20002, '한동성', 1, 'A02', 20210302, null, null),
(20003, '김재선', 2, 'A01', 20200302, null, null),
(20004, '이재선', 2, 'A02', 20200302, null, null);
                                    
desc score;
select * from score;
insert into score values
(null, 20001, 1, 80),
(null, 20001, 2, 81), 
(null, 20001, 3, 82), 
(null, 20001, 4, 83), 
(null, 20001, 5, 84), 
(null, 20002, 1, 70),
(null, 20002, 2, 71),
(null, 20002, 3, 72),
(null, 20002, 4, 73),
(null, 20002, 5, 74),
(null, 20003, 1, 60),
(null, 20003, 2, 61),
(null, 20003, 3, 62),
(null, 20003, 4, 63),
(null, 20003, 5, 64),
(null, 20004, 1, 50),
(null, 20004, 2, 52),
(null, 20004, 3, 53),
(null, 20004, 4, 54),
(null, 20004, 5, 55);
