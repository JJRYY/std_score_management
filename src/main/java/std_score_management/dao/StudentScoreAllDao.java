package std_score_management.dao;

import java.util.List;

import std_score_management.dto.Student;
import std_score_management.dto.StudentScoreAll;

public interface StudentScoreAllDao {
	List<StudentScoreAll> selectStudentScoreAll();
	
	StudentScoreAll selectStudentScoreByNo(Student student);
	
	
}	
