package std_score_management.service;

import java.util.List;

import std_score_management.dao.StudentDao;
import std_score_management.dao.impl.StudentDaoImpl;
import std_score_management.dto.Student;

public class StudentService {
	private StudentDao stdDao = StudentDaoImpl.getInstance();
	
	public List<Student> showStudents() {
		return stdDao.selectStudentByAll();
	}
	
	public void addStudent (Student student) {
		stdDao.insertStudent(student);
	}
	
	public void removeStudent (Student student) {
		stdDao.deleteStudent(student);
	}
	
	public void updateStudent (Student student) {
		stdDao.updateStudent(student);
	}
	
	public List<Student> showStudentScore() {
		return stdDao.selectStudentScore();
	}
}
