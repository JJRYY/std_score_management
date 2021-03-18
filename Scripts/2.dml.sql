select user(), database();

show tables;

desc ban;
desc subject;
desc student;
desc score;
desc std_detail;

select * from ban;
insert into ban values ('A01');
insert into ban values ('A02');
insert into ban values ('B01');
insert into ban values ('B02');

select * from subject;
insert into subject values (101, '국어');
insert into subject values (201, '영어');
insert into subject values (301, '수학');
insert into subject values (401, '사회');
insert into subject values (501, '과학');

desc student;
select * from student;
insert into student values (20001, '박재선', 'A01');
insert into student values (20002, '한동성', 'A02');
insert into student values (20003, '정정일', 'A01');
insert into student values (20004, '정명훈', 'B01');
insert into student values (20005, '임정만', 'B02');
insert into student values (20006, '임성준', 'B01');
insert into student values (20007, '윤석수', 'A01');
insert into student values (20008, '이준민', 'A02');
insert into student values (20009, '이강길', 'A01');
                                    
desc score;
select * from score;
insert into score values (null, 20001, 101, 80);
insert into score values (null, 20001, 201, 81); 
insert into score values (null, 20001, 301, 82); 
insert into score values (null, 20001, 401, 83); 
insert into score values (null, 20001, 501, 84); 
insert into score values (null, 20002, 101, 70);
insert into score values (null, 20002, 201, 71);
insert into score values (null, 20002, 301, 72);
insert into score values (null, 20002, 401, 73);
insert into score values (null, 20002, 501, 74);
insert into score values (null, 20003, 101, 60);
insert into score values (null, 20003, 201, 61);
insert into score values (null, 20003, 301, 62);
insert into score values (null, 20003, 401, 63);
insert into score values (null, 20003, 501, 64);
insert into score values (null, 20004, 101, 50);
insert into score values (null, 20004, 201, 52);
insert into score values (null, 20004, 301, 53);
insert into score values (null, 20004, 401, 54);
insert into score values (null, 20004, 501, 55);
insert into score values (null, 20005, 101, 65);
insert into score values (null, 20005, 201, 46);
insert into score values (null, 20005, 301, 34);
insert into score values (null, 20005, 401, 78);
insert into score values (null, 20005, 501, 98);
insert into score values (null, 20006, 101, 56);
insert into score values (null, 20006, 201, 67);
insert into score values (null, 20006, 301, 88);
insert into score values (null, 20006, 401, 75);
insert into score values (null, 20006, 501, 90);
insert into score values (null, 20007, 101, 78);
insert into score values (null, 20007, 201, 89);
insert into score values (null, 20007, 301, 90);
insert into score values (null, 20007, 401, 66);
insert into score values (null, 20007, 501, 50);
insert into score values (null, 20008, 101, 68);
insert into score values (null, 20008, 201, 58);
insert into score values (null, 20008, 301, 89);
insert into score values (null, 20008, 401, 50);
insert into score values (null, 20008, 501, 80);
insert into score values (null, 20009, 101, 46);
insert into score values (null, 20009, 201, 66);
insert into score values (null, 20009, 301, 90);
insert into score values (null, 20009, 401, 80);
insert into score values (null, 20009, 501, 70);
                                        

desc std_detail;
select * from std_detail;