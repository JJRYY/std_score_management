package std_score_management.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import std_score_management.dao.LoginDao;
import std_score_management.dto.Login;
import std_score_management.util.JdbcUtil;

public class LoginDaoImpl implements LoginDao {
private static LoginDaoImpl instance = new LoginDaoImpl();
	
	public static LoginDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public Login selectLoginUser(String id, String passwd) {
		String sql = "select id, passwd, email from login where id=? and passwd=password(?)";
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					return getLoginUser(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Login getLoginUser(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		
		return new Login(id);
	}

}
