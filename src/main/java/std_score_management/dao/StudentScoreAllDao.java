package std_score_management.dao;

import java.util.List;

import std_score_management.dto.Student;
import std_score_management.dto.StudentScoreAll;
import std_score_management.dto.Subject;

public interface StudentScoreAllDao {
	List<StudentScoreAll> selectStudentScoreAll();
	
	StudentScoreAll selectStudentScoreByNo(Student student);
	
	List<StudentScoreAll> selectStudentScoreTopByAvg(int cnt);
	
	List<StudentScoreAll> selectStudentScoreTopBySubject(Subject subject, int cnt);
}	
