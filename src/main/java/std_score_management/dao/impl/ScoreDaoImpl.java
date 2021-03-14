package std_score_management.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import std_score_management.dao.ScoreDao;
import std_score_management.dto.Score;
import std_score_management.dto.Student;
import std_score_management.dto.Subject;
import std_score_management.util.JdbcUtil;

public class ScoreDaoImpl implements ScoreDao {
	private static ScoreDaoImpl instance = new ScoreDaoImpl();
	
	public static ScoreDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Score> selectScoreByAll() {
		String sql = "select scoreNo, stdNo, subjectCode, stdScore from score";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Score> list = new ArrayList<>();
				do {
					list.add(getScore(rs));
				} while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Score getScore(ResultSet rs) throws SQLException {
		int scoreNo = rs.getInt("scoreNo");
		Student stdNo = new Student(rs.getInt("stdNo"));
		Subject subjectCode = new Subject(rs.getInt("subjectCode"));
		int stdScore = rs.getInt("stdScore");
		
		return new Score(scoreNo, stdNo, subjectCode, stdScore);
	}

	@Override
	public Score selectScoreByNo(Score score) {
		String sql = "select scoreNo, stdNo, subjectCode, stdScore from score where stdNo = ? and subjectCode = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, score.getStdNo().getStdNo());
			pstmt.setInt(2, score.getSubjectCode().getSubjectCode());
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					return getScore(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertScore(Score score) {
		String sql = "insert into score values (null, ?, ?, ?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, score.getStdNo().getStdNo());
			pstmt.setInt(3, score.getSubjectCode().getSubjectCode());
			pstmt.setInt(4, score.getStdScore());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateScore(Score score) {
		String sql = "update score set stdScore = ? where stdNo = ? and subjectCode = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, score.getStdScore());
			pstmt.setInt(2, score.getStdNo().getStdNo());
			pstmt.setInt(3, score.getSubjectCode().getSubjectCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteScore(Score score) {
		String sql = "delete from score where stdNo = ? and subjectCode = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, score.getStdNo().getStdNo());
			pstmt.setInt(2, score.getSubjectCode().getSubjectCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
