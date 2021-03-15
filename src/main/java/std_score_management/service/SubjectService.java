package std_score_management.service;

import java.util.List;

import std_score_management.dao.SubjectDao;
import std_score_management.dao.impl.SubjectDaoImpl;
import std_score_management.dto.Subject;

public class SubjectService {
private SubjectDao dao = SubjectDaoImpl.getInstance();
	
	public List<Subject> showSubjects(){
		return dao.selectSubjectByAll();
	}
	
	public void addSubject(Subject subject){
		dao.insertSubject(subject);
	}
	
	public void updateSubject(Subject subject) {
		dao.updateSubject(subject);
	}
	
	public void removeSubject(Subject subject) {
		dao.deleteSubject(subject);
	}

	
}
