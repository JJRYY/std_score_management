package std_score_management.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import std_score_management.dao.BanDao;
import std_score_management.dto.Ban;
import std_score_management.util.JdbcUtil;

public class BanDaoImpl implements BanDao {
	private static final BanDaoImpl instance = new BanDaoImpl();
	
	public BanDaoImpl() {
	}
	
	public static BanDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Ban> selectBanByAll() {
		String sql = "select banCode from ban";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Ban> list = new ArrayList<>();
				do {
					list.add(getBan(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Ban getBan(ResultSet rs) throws SQLException {
		String banCode = rs.getString("banCode");
		return new Ban(banCode);
	}

	@Override
	public Ban selectBanByCode(Ban ban) {
		String sql = "select banCode from ban where banCode = ?";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, ban.getBanCode());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getBan(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertBan(Ban ban) {
		String sql = "insert into ban values (?)";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, ban.getBanCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBan(Ban ban) {
		String sql = "delete from ban where banCode = ?";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, ban.getBanCode());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
