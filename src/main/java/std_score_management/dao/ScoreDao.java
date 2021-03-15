package std_score_management.dao;

import java.util.List;

import std_score_management.dto.Score;

public interface ScoreDao {
	List<Score> selectScoreByAll();
//	Score selectScoreByNo(Score score);
	List<Score> selectScoreByNo(Score score);
	
	int insertScore(Score score);
	int updateScore(Score score);
	int deleteScore(Score score);
}
