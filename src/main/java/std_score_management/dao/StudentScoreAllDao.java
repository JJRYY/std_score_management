package std_score_management.dao;

import java.util.List;

import std_score_management.dto.Ban;
import std_score_management.dto.Student;
import std_score_management.dto.StudentScoreAll;

public interface StudentScoreAllDao {
	List<StudentScoreAll> selectStudentScoreAll();
	
	StudentScoreAll selectStudentScoreByNo(Student student);
	
	List<StudentScoreAll> selectStudentScoreOrderByAvg();
	
	List<StudentScoreAll> selectStudentScoreTopByAvg(int cnt);
	
	List<StudentScoreAll> selectStudentScoreOrderBySubject(String s);
	
	List<StudentScoreAll> selectStudentScoreTopBySubject(String s, int cnt);
	
	List<StudentScoreAll> selectStudentScoreByBan(Ban ban);
	
	List<StudentScoreAll> selectStudentScoreByBanSubject(Ban ban, String s);
}	
