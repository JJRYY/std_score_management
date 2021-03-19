select user(), database();

create or replace view vw_student_score
as
select s.stdNo, stdName, banCode,  
	sum(if(subjectCode = 101, stdScore, 0)) as kor,
	sum(if(subjectCode = 201, stdScore, 0)) as eng,
	sum(if(subjectCode = 301, stdScore, 0)) as math,
	sum(if(subjectCode = 401, stdScore, 0)) as soc,
	sum(if(subjectCode = 501, stdScore, 0)) as sci
	from student s join score c on s.stdNo = c.stdNo
	group by stdNo;
	
select stdNo, stdName, banCode, kor, eng, math, soc, sci from vw_student_score;