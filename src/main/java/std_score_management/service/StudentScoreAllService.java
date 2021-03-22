package std_score_management.service;

import java.util.List;

import std_score_management.dao.StudentScoreAllDao;
import std_score_management.dao.SubjectDao;
import std_score_management.dao.impl.StudentScoreAllDaoImpl;
import std_score_management.dao.impl.SubjectDaoImpl;
import std_score_management.dto.Student;
import std_score_management.dto.StudentScoreAll;
import std_score_management.dto.Subject;

public class StudentScoreAllService {
	private StudentScoreAllDao stdScoreAllDao = StudentScoreAllDaoImpl.getInstance();
	private SubjectDao subjectDao = SubjectDaoImpl.getInstance();
	
	public StudentScoreAll selectStudentScoreByStdNo(Student student) {
		return stdScoreAllDao.selectStudentScoreByNo(student);
	}
	
	public List<StudentScoreAll> showStudentScore(){
		return stdScoreAllDao.selectStudentScoreAll();
	}
	
	public List<StudentScoreAll> showStudentScoreTopByAvg(int cnt){
		return stdScoreAllDao.selectStudentScoreTopByAvg(cnt);
	}
	
	public List<Subject> showSubjectList(){
		return subjectDao.selectSubjectByAll();
	}
}
