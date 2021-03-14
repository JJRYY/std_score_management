package std_score_management.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import std_score_management.dao.StudentDao;
import std_score_management.dto.Ban;
import std_score_management.dto.Student;
import std_score_management.util.JdbcUtil;

public class StudentDaoImpl implements StudentDao {
	private static StudentDaoImpl instance = new StudentDaoImpl();
	
	public static StudentDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public List<Student> selectStudentByAll() {
		String sql = "select stdNo, stdName, stdGrade, banCode, enterDate from student";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Student> list = new ArrayList<>();
				do {
					list.add(getStudent(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Student getStudent(ResultSet rs) throws SQLException {
		int stdNo = rs.getInt("stdNo");
		String stdName = rs.getString("stdName");
		int stdGrade = rs.getInt("stdGrade");
		Ban ban = new Ban(rs.getString("banCode"));
		Date enterDate = rs.getDate("enterDate");
		
		return new Student(stdNo, stdName, stdGrade, ban, enterDate);
	}

	@Override
	public Student selectStudentByNo(Student student) {
		String sql = "select stdNo, stdName, stdGrade, banCode, enterDate from student where stdNo = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, student.getStdNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					return getStudent(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertStudent(Student student) {
		String sql = "insert into student values (?, ?, ?, ?, ?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, student.getStdNo());
			pstmt.setString(2, student.getStdName());
			pstmt.setInt(3, student.getStdGrade());
			pstmt.setString(4, student.getBanCode().getBanCode());
			pstmt.setTimestamp(5, student.getEnterDate().getTime()); // ?
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		String sql = "update student set stdName = ?, stdGrade = ?, banCode = ?, enterDate = ? where stdNo = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, student.getStdName());
			pstmt.setInt(2, student.getStdGrade());
			pstmt.setString(3, student.getBanCode().getBanCode());
			pstmt.setDate(4, student.getEnterDate()); // ?
			pstmt.setInt(5, student.getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudent(Student student) {
		String sql = "delete from student where stdNo = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, student.getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
