package std_score_management.service;

import std_score_management.dao.impl.StudentDetailDaoImpl;
import std_score_management.dto.Student;
import std_score_management.dto.StudentDetail;

public class StudentDetailService {
	private StudentDetailDaoImpl detailDao = StudentDetailDaoImpl.getInstance();
	
	public StudentDetail showStudentDetailByNo(Student student){
		return detailDao.selectStudentDetailByNo(student);
	}
	
	public void addStudentDetail(StudentDetail stdDetail) {
		detailDao.insertStudentDetail(stdDetail);
	}
	
	public void updateStudentDetail(StudentDetail stdDetail) {
		detailDao.updateStudentDetail(stdDetail);
	}
	
	public void removeStudentDetail(Student student) {
		detailDao.deleteStudentDetail(student);
	}
}
