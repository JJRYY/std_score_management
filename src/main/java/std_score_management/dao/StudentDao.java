package std_score_management.dao;

import java.util.List;

import std_score_management.dto.Student;

public interface StudentDao {
	List<Student> selectStudentByAll();
	Student selectStudentByNo(Student student);
	
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(Student student);
}
