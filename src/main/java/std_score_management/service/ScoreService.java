package std_score_management.service;

import java.util.List;

import std_score_management.dao.ScoreDao;
import std_score_management.dao.impl.ScoreDaoImpl;
import std_score_management.dto.Score;

public class ScoreService {
private ScoreDao dao = ScoreDaoImpl.getInstance();
	
	public List<Score> showScores(){
		return dao.selectScoreByAll();
	}
	
	public void addScore(Score score){
		dao.insertScore(score);
	}
	
	public void updateScore(Score score) {
		dao.updateScore(score);
	}
	
	public void removeScore(Score score) {
		dao.deleteScore(score);
	}
}
