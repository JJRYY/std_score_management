package std_score_management.service;

import java.util.List;

import std_score_management.dao.BanDao;
import std_score_management.dao.impl.BanDaoImpl;
import std_score_management.dto.Ban;

public class BanService {
	private BanDao dao = BanDaoImpl.getInstance();
	
	public List<Ban> showBans(){
		return dao.selectBanByAll();
	}
	
	public void addBan(Ban ban) {
		dao.insertBan(ban);
	}
	
	public void removeBan(Ban ban) {
		dao.deleteBan(ban);
	}

}
