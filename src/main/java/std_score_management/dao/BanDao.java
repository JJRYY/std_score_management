package std_score_management.dao;

import java.util.List;

import std_score_management.dto.Ban;

public interface BanDao {
	List<Ban> selectBanByAll();
	Ban selectBanByCode(Ban ban);
	
	int insertBan(Ban ban);
	int deleteBan(Ban ban);
}
