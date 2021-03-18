select user(), database();

select banCode from ban;

select subjectCode, subjectName from subject;

select stdNo, stdName, stdGrade, banCode, enterDate, photoName, stdPhoto from student;

select scoreNo, stdNo, subjectCode, stdScore from score;

select scoreNo, stdNo, subjectCode, stdScore from score where stdNo = 20001 and subjectCode = 1;

delete from score where stdNo = 20001 and subjectCode = 5; 

insert into score values (null, 20001, 5, 84);

update score set stdScore = 85 where stdNo = 20001 and subjectCode = 1;

select * from student;
select * from score;
select * from ban;

update ban set banCode = 'A03' where banCode = 'A01';

select s.stdNo, stdName, c.subjectCode, stdScore
	from student s join score c on s.stdNo = c.stdNo; 

-- 학생마다의 점수 피벗테이블
select s.stdNo, stdName,             
	sum(if(subjectCode = 101, stdScore, 0)) as '국어',
	sum(if(subjectCode = 201, stdScore, 0)) as '영어',
	sum(if(subjectCode = 301, stdScore, 0)) as '수학',
	sum(if(subjectCode = 401, stdScore, 0)) as '사회',
	sum(if(subjectCode = 501, stdScore, 0)) as '과학'
	from student s join score c on s.stdno = c.stdno
	group by stdName;

insert into student(stdNo, stdName, stdGrade, banCode) values
(30001, '미포', 'B01');

delete from student 
	where stdNo = 20001;

delete from score 
	where stdNo = 20001;

select * from student;
select * from score;

select stdNo, subjectCode, stdScore from score where stdNo = 20001;

insert into student(stdNo, stdName, banCode) values
(40001, '김김', 'A01');

delete from subject where subjectCode = 101;
	