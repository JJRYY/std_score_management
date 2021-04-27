package std_score_management.dao;

import std_score_management.dto.Login;

public interface LoginDao {
	Login selectLoginUser(String id, String passwd);
}
