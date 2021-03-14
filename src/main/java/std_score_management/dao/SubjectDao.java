package std_score_management.dao;

import java.util.List;

import std_score_management.dto.Subject;

public interface SubjectDao {
	List<Subject> selectSubjectByAll();
	Subject selectSubjectByNo(Subject subject);
	
	int insertSubject(Subject subject);
	int updateSubject(Subject subject);
	int deleteSubject(Subject subject);
	
}
