package std_score_management.service;

import java.util.List;

import std_score_management.dao.BanDao;
import std_score_management.dao.StudentScoreAllDao;
import std_score_management.dao.SubjectDao;
import std_score_management.dao.impl.BanDaoImpl;
import std_score_management.dao.impl.StudentScoreAllDaoImpl;
import std_score_management.dao.impl.SubjectDaoImpl;
import std_score_management.dto.Ban;
import std_score_management.dto.Student;
import std_score_management.dto.StudentScoreAll;
import std_score_management.dto.Subject;

public class StudentScoreAllService {
	private StudentScoreAllDao stdScoreAllDao = StudentScoreAllDaoImpl.getInstance();
	private SubjectDao subjectDao = SubjectDaoImpl.getInstance();
	private BanDao banDao = BanDaoImpl.getInstance();
	
	public StudentScoreAll selectStudentScoreByStdNo(Student student) {
		return stdScoreAllDao.selectStudentScoreByNo(student);
	}
	
	public List<StudentScoreAll> showStudentScore(){
		return stdScoreAllDao.selectStudentScoreAll();
	}
	
	public List<StudentScoreAll> showStudentScoreOrderByAvg(){
		return stdScoreAllDao.selectStudentScoreOrderByAvg();
	}
	
	public List<StudentScoreAll> showStudentScoreTopByAvg(int cnt){
		return stdScoreAllDao.selectStudentScoreTopByAvg(cnt);
	}
	
	public List<StudentScoreAll> showStudentScoreOrderBySubject(String s){
		return stdScoreAllDao.selectStudentScoreOrderBySubject(s);
	}
	
	public List<StudentScoreAll> showStudentScoreTopBySubject(String s, int cnt){
		return stdScoreAllDao.selectStudentScoreTopBySubject(s, cnt);
	}
	
	public List<Subject> showSubjectList(){
		return subjectDao.selectSubjectByAll();
	}
	
	public List<Ban> showBanList(){
		return banDao.selectBanByAll();
	}
	
	public List<StudentScoreAll> showStudentScoreByBan(Ban ban) {
		return stdScoreAllDao.selectStudentScoreByBan(ban);
	}
	
	public List<StudentScoreAll> showStudentScoreByBanSubject(Ban ban, String s){
		return stdScoreAllDao.selectStudentScoreByBanSubject(ban, s);
	}
	
	public double avgSubjectScore(String s) {
		return stdScoreAllDao.avgSubjectScore(s);
	}
	
	public double avgSubjectScoreByBan(String s, Ban ban) {
		return stdScoreAllDao.avgSubjectScoreByBan(s, ban);
	}
}
