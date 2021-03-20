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
select s.stdNo, stdName, banCode,  
	sum(if(subjectCode = 101, stdScore, 0)) as kor,
	sum(if(subjectCode = 201, stdScore, 0)) as eng,
	sum(if(subjectCode = 301, stdScore, 0)) as math,
	sum(if(subjectCode = 401, stdScore, 0)) as soc,
	sum(if(subjectCode = 501, stdScore, 0)) as sci
	from student s join score c on s.stdNo = c.stdNo
	group by stdNo;

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

select stdNo, gender, enterDate, stdPhoto from std_detail;

delete from std_detail where stdNo = 20001;
	
select s.stdNo, stdName, banCode,  
	sum(if(subjectCode = 101, stdScore, 0)) as kor,
	sum(if(subjectCode = 201, stdScore, 0)) as eng,
	sum(if(subjectCode = 301, stdScore, 0)) as math,
	sum(if(subjectCode = 401, stdScore, 0)) as soc,
	sum(if(subjectCode = 501, stdScore, 0)) as sci,
	sum(stdScore) as '총점',
	avg(stdScore) as '평균'
	from student s join score c on s.stdNo = c.stdNo
	group by stdNo;

-- 상위 몇개만 가져오기
select * from vw_student_score;
-- 과목점수 상위 5개만 가져오기
select stdNo, stdName, banCode, kor, eng, math, soc, sci 
	from vw_student_score
	order by sci desc limit 5;

