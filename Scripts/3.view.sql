select user(), database();

create or replace view vw_student_score
as
select s.stdNo, stdName, banCode,  
	sum(if(subjectCode = 101, stdScore, 0)) as '국어',
	sum(if(subjectCode = 201, stdScore, 0)) as '영어',
	sum(if(subjectCode = 301, stdScore, 0)) as '수학',
	sum(if(subjectCode = 401, stdScore, 0)) as '사회',
	sum(if(subjectCode = 501, stdScore, 0)) as '과학',
	sum(stdScore) as 'sumScore',
	avg(stdScore) as 'avgScore'
	from student s join score c on s.stdNo = c.stdNo
	group by stdNo;
	
	
select * from vw_student_score;

select stdNo, stdName, banCode, 국어, 영어, 수학, 사회, 과학, SumScore, avgScore from vw_student_score;