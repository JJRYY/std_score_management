package std_score_management.service;

import java.util.List;

import std_score_management.dao.StudentScoreAllDao;
import std_score_management.dao.impl.StudentScoreAllDaoImpl;
import std_score_management.dto.Student;
import std_score_management.dto.StudentScoreAll;

public class StudentScoreAllService {
	private StudentScoreAllDao stdScoreAllDao = StudentScoreAllDaoImpl.getInstance();
	
	public StudentScoreAll selectStudentScoreByStdNo(Student student) {
		return stdScoreAllDao.selectStudentScoreByNo(student);
	}
	
	public List<StudentScoreAll> showStudentScore(){
		return stdScoreAllDao.selectStudentScoreAll();
	}
}
