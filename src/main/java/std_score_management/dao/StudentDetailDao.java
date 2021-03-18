package std_score_management.dao;

import std_score_management.dto.Student;
import std_score_management.dto.StudentDetail;

public interface StudentDetailDao {
	StudentDetail selectStudentDetailByNo(Student student);
	
	int insertStudentDetail(StudentDetail stdDetail);
	int updateStudentDetail(StudentDetail stdDetail);
	int deleteStudentDetail(Student student);
}
