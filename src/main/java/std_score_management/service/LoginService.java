package std_score_management.service;

import std_score_management.dao.LoginDao;
import std_score_management.dao.impl.LoginDaoImpl;
import std_score_management.dto.Login;

public class LoginService {
	private LoginDao dao = LoginDaoImpl.getInstance();
	
	public Login selectLoginUser(String id, String passwd) {
		return dao.selectLoginUser(id, passwd);
	}
}
