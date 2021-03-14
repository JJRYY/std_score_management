-- 성적관리
DROP SCHEMA IF EXISTS std_score;

-- 성적관리
CREATE SCHEMA std_score;

-- 학생
CREATE TABLE std_score.student (
	stdNo     INT(6)      NOT NULL COMMENT '학번', -- 학번
	stdName   VARCHAR(6)  NOT NULL COMMENT '이름', -- 이름
	stdGrade  INT(1)      NULL     COMMENT '학년', -- 학년
	banCode   VARCHAR(4)  NULL     COMMENT '분반', -- 분반
	enterDate DATE        NULL     COMMENT '입학일', -- 입학일
	photoName VARCHAR(50) NULL     COMMENT '파일명', -- 파일명
	stdPhoto  BLOB        NULL     COMMENT '사진' -- 사진
)
COMMENT '학생';

-- 학생
ALTER TABLE std_score.student
	ADD CONSTRAINT PK_student -- 학생 기본키
		PRIMARY KEY (
			stdNo -- 학번
		);

-- 분반
CREATE TABLE std_score.ban (
	banCode VARCHAR(4) NOT NULL COMMENT '분반' -- 분반
)
COMMENT '분반';

-- 분반
ALTER TABLE std_score.ban
	ADD CONSTRAINT PK_ban -- 분반 기본키
		PRIMARY KEY (
			banCode -- 분반
		);

-- 과목
CREATE TABLE std_score.subject (
	subjectCode INT(3)      NOT NULL COMMENT '과목코드', -- 과목코드
	subjectName VARCHAR(20) NOT NULL COMMENT '과목명' -- 과목명
)
COMMENT '과목';

-- 과목
ALTER TABLE std_score.subject
	ADD CONSTRAINT PK_subject -- 과목 기본키
		PRIMARY KEY (
			subjectCode -- 과목코드
		);

-- 점수
CREATE TABLE std_score.score (
	scoreNo     INT    NOT NULL COMMENT '순번', -- 순번
	stdNo       INT(6) NOT NULL COMMENT '학번', -- 학번
	subjectCode INT(3) NOT NULL COMMENT '과목코드', -- 과목코드
	stdScore    INT(3) NULL     COMMENT '점수' -- 점수
)
COMMENT '점수';

-- 점수
ALTER TABLE std_score.score
	ADD CONSTRAINT PK_score -- 점수 기본키
		PRIMARY KEY (
			scoreNo -- 순번
		);

-- 학생
ALTER TABLE std_score.student
	ADD CONSTRAINT FK_ban_TO_student -- 분반 -> 학생
		FOREIGN KEY (
			banCode -- 분반
		)
		REFERENCES std_score.ban ( -- 분반
			banCode -- 분반
		);

-- 점수
ALTER TABLE std_score.score
	ADD CONSTRAINT FK_student_TO_score -- 학생 -> 점수
		FOREIGN KEY (
			stdNo -- 학번
		)
		REFERENCES std_score.student ( -- 학생
			stdNo -- 학번
		);

-- 점수
ALTER TABLE std_score.score
	ADD CONSTRAINT FK_subject_TO_score -- 과목 -> 점수
		FOREIGN KEY (
			subjectCode -- 과목코드
		)
		REFERENCES std_score.subject ( -- 과목
			subjectCode -- 과목코드
		);

-- 권한 부여
grant all 
	on std_score.*
	to 'user_std_score'@'localhost' identified by 'rootroot';

-- photo(photoNo), score(scoreNo) auto_increment 추가
alter table std_score.photo 
	modify photoNo int not null auto_increment;
	
alter table std_score.score
	modify scoreNo int not null auto_increment;

-- delete on cascade 추가. 학생정보를 삭제하면 점수테이블에서의 점수도 삭제


