package std_score_management.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import std_score_management.dao.SubjectDao;
import std_score_management.dto.Subject;
import std_score_management.util.JdbcUtil;

public class SubjectDaoImpl implements SubjectDao {
	private static final SubjectDaoImpl instance = new SubjectDaoImpl();
	
	public static SubjectDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public List<Subject> selectSubjectByAll() {
		String sql = "select subjectCode, subjectName from subject";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Subject> list = new ArrayList<>();
				do {
					list.add(getSubject(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Subject getSubject(ResultSet rs) throws SQLException {
		int subjectCode = rs.getInt("subjectCode");
		String subjectName = rs.getString("subjectName");
		return new Subject(subjectCode, subjectName);
	}

	@Override
	public Subject selectSubjectByNo(Subject subject) {
		String sql = "select subjectCode, subjectName from subject where subjectCode = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, subject.getSubjectCode());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getSubject(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertSubject(Subject subject) {
		String sql = "insert into subject values (?, ?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, subject.getSubjectCode());
			pstmt.setString(2, subject.getSubjectName());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateSubject(Subject subject) {
		String sql = "update subject set subjectName = ? where subjectCode = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, subject.getSubjectName());
			pstmt.setInt(2, subject.getSubjectCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteSubject(Subject subject) {
		String sql = "delete from subject where subjectCode = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, subject.getSubjectCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
