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
select * from subject;

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
	sum(if(subjectCode = 101, stdScore, 0)) as 'kor',
	sum(if(subjectCode = 201, stdScore, 0)) as 'eng',
	sum(if(subjectCode = 301, stdScore, 0)) as 'math',
	sum(if(subjectCode = 401, stdScore, 0)) as 'soc',
	sum(if(subjectCode = 501, stdScore, 0)) as 'sci',
	sum(stdScore) as 'SumScore',
	avg(stdScore) as 'avgScore'
	from student s join score c on s.stdNo = c.stdNo
	group by stdNo;

select * from student;
select * from score; 
select * from subject;

insert into score values (null, 40001, 101, 80);
insert into score values (null, 40001, 201, 70);

select * from vw_student_score;

-- 평균 내림차순 정렬
select stdNo, stdName, banCode, 국어, 영어, 수학, 사회, 과학, sumScore, avgScore
	from vw_student_score
	order by avgScore desc;

-- 상위 몇개만 가져오기
select stdNo, stdName, banCode, 국어, 영어, 수학, 사회, 과학, sumScore, avgScore
	from vw_student_score
	order by avgScore desc limit 5;

-- 과목 점수 내림차순 정렬
select stdNo, stdName, banCode, 국어, 영어, 수학, 사회, 과학, sumScore, avgScore
	from vw_student_score
	order by 수학 desc, avgScore desc limit 5; 

-- 과목점수 상위 5개만 가져오기
select stdNo, stdName, banCode, 국어, 영어, 수학, 사회, 과학, sumScore, avgScore
	from vw_student_score
	order by 국어 desc limit 5;

select stdNo, stdName, banCode, 국어, 영어, 수학, 사회, 과학, sumScore, avgScore
	from vw_student_score
	order by 사회 desc limit 13;



select s.stdNo, stdName, banCode,  
	sum(if(subjectCode = 101, stdScore, 0)) as '국어',
	sum(if(subjectCode = 201, stdScore, 0)) as '영어',
	sum(if(subjectCode = 301, stdScore, 0)) as '수학',
	sum(if(subjectCode = 401, stdScore, 0)) as '사회',
	sum(if(subjectCode = 501, stdScore, 0)) as '과학',
	sum(stdScore) as 'sumScore',
	avg(stdScore) as 'avgScore'
	from student s join score c on s.stdNo = c.stdNo
	group by stdNo
	order by 과학 desc limit 5;

select * from subject;


-- 반 별 조회 (평균 내림차순)
select stdNo, stdName, banCode, 국어, 영어, 수학, 사회, 과학, sumScore, avgScore
	from vw_student_score
	where banCode='A01'
	order by avgScore desc; 
	
-- 반 별 조회(과목점수 내림차순)
select stdNo, stdName, banCode, 국어, 영어, 수학, 사회, 과학, sumScore, avgScore
	from vw_student_score
	where banCode='B01'
	order by 국어 desc, avgScore desc; 
	
-- 로그인 아이디 조회
select id, passwd, email from login;
select id, passwd, email from login where id='test' and passwd=password('test');

-- 반별 평균점수 가져오기
select * from vw_student_score;
select avg(국어) from vw_student_score;
select avg(국어) from vw_student_score where banCode = 'A01';
select avg(sumScore) from vw_student_score where banCode = 'A01';