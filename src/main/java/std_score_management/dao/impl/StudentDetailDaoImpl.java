package std_score_management.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import std_score_management.dao.StudentDetailDao;
import std_score_management.dto.Student;
import std_score_management.dto.StudentDetail;
import std_score_management.ui.exception.SqlConstraintException;
import std_score_management.util.JdbcUtil;

public class StudentDetailDaoImpl implements StudentDetailDao {
	private static StudentDetailDaoImpl instance = new StudentDetailDaoImpl();
	
	public static StudentDetailDaoImpl getInstance() {
		if (instance == null) {
			instance = new StudentDetailDaoImpl();
		}
		return instance;
	}
	
	private StudentDetailDaoImpl() {
	}
	
	@Override
	public StudentDetail selectStudentDetailByNo(Student student) {
		String sql = "select stdNo, gender, enterDate, stdPhoto from std_detail where stdNo = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, student.getStdNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					return getStudentDetail(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private StudentDetail getStudentDetail(ResultSet rs) throws SQLException {
		int stdNo = rs.getInt("stdNo");
		boolean gender = rs.getBoolean("gender");
		Date enterDate = rs.getTimestamp("enterDate");
		byte[] stdPhoto = rs.getBytes("stdPhoto");
		
		return new StudentDetail(stdNo, gender, enterDate, stdPhoto);
	}

	@Override
	public int insertStudentDetail(StudentDetail stdDetail) {
		String sql = "insert into std_detail(stdNo, gender, enterDate, stdPhoto) values(?, ?, ?, ?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, stdDetail.getStdNo());
			pstmt.setBoolean(2, stdDetail.isGender());
			pstmt.setTimestamp(3, new Timestamp(stdDetail.getEnterDate().getTime()));
			pstmt.setBytes(4, stdDetail.getStdPhoto());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new SqlConstraintException(e.getMessage(), e);
		}
	}

	@Override
	public int updateStudentDetail(StudentDetail stdDetail) {
		String sql = "update std_detail set gender = ?, enterDate = ?, stdPhoto = ? where stdNo = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setBoolean(1, stdDetail.isGender());
			pstmt.setTimestamp(2, new Timestamp(stdDetail.getEnterDate().getTime()));
			pstmt.setBytes(3, stdDetail.getStdPhoto());
			pstmt.setInt(4, stdDetail.getStdNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudentDetail(Student student) {
		String sql = "delete from std_detail where stdNo = ?";
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
