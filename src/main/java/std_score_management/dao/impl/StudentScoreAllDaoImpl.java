package std_score_management.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import std_score_management.dao.StudentScoreAllDao;
import std_score_management.dto.Ban;
import std_score_management.dto.Student;
import std_score_management.dto.StudentScoreAll;
import std_score_management.dto.Subject;
import std_score_management.util.JdbcUtil;

public class StudentScoreAllDaoImpl implements StudentScoreAllDao {
	private static StudentScoreAllDaoImpl instance = new StudentScoreAllDaoImpl();
	
	public StudentScoreAllDaoImpl() {
		
	}
	
	public static StudentScoreAllDaoImpl getInstance() {
		if (instance == null) {
			instance = new StudentScoreAllDaoImpl();
		}
		return instance;
	}
	
	@Override
	public List<StudentScoreAll> selectStudentScoreAll() {
		String sql = "select stdNo, stdName, banCode, kor, eng, math, soc, sci from vw_student_score";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<StudentScoreAll> list = new ArrayList<>();
				do {
					list.add(getStudentScoreAll(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private StudentScoreAll getStudentScoreAll(ResultSet rs) throws SQLException{
		Student stdNo = new Student(rs.getInt("stdNo"));
		String stdName = rs.getString("stdName");
		Ban banCode = new Ban(rs.getString("banCode"));
		int kor = rs.getInt("kor");
		int eng = rs.getInt("eng");
		int math = rs.getInt("math");
		int soc = rs.getInt("soc");
		int sci = rs.getInt("sci");
		
		return new StudentScoreAll(stdNo, stdName, banCode, kor, eng, math, soc, sci);
	}

	@Override
	public StudentScoreAll selectStudentScoreByNo(Student student) {
		String sql = "select stdNo, stdName, banCode, kor, eng, math, soc, sci"
				+ " from vw_student_score"
				+ " where stdNo = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, student.getStdNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					return getStudentScoreAll(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StudentScoreAll> selectStudentScoreTopByAvg(int cnt) {
		String sql = "select stdNo, stdName, banCode, kor, eng, math, soc, sci" + 
				"	from vw_student_score" + 
				"	order by avgScore desc limit ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, cnt);
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					List<StudentScoreAll> list = new ArrayList<>();
					do {
						list.add(getStudentScoreAll(rs));
					} while (rs.next());
					return list;
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StudentScoreAll> selectStudentScoreTopBySubject(Subject subject, int cnt) {
		String sql = "select stdNo, stdName, banCode, kor, eng, math, soc, sci" + 
				"	from vw_student_score" + 
				"	order by %?"
				+ " desc limit ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, subject.getSubjectName() + "%");
			pstmt.setInt(2, cnt);
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					List<StudentScoreAll> list = new ArrayList<>();
					do {
						list.add(getStudentScoreAll(rs));
					} while (rs.next());
					return list;
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
