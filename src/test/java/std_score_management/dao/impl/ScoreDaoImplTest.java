package std_score_management.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import std_score_management.dao.ScoreDao;
import std_score_management.dto.Score;
import std_score_management.dto.Student;
import std_score_management.dto.Subject;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScoreDaoImplTest {
private ScoreDao dao = ScoreDaoImpl.getInstance();
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test04SelectScoreByAll() {
		System.out.printf("%s()%n", "testSelectScoreByAll");
		List<Score> scoreList = dao.selectScoreByAll();
		Assert.assertNotNull(scoreList);
		for (Score s : scoreList) {
			System.out.println(s);
		}
	}

	@Test
	public void test05SelectScoreByNo() {
		System.out.printf("%s()%n", "testSelectScoreByNo");
		Score selScore = new Score(new Student(20001));
		List<Score> scoreList = dao.selectScoreByNo(selScore);
		Assert.assertNotNull(scoreList);
		for (Score t : scoreList) {
			System.out.println(t);
		}
	}

	@Test
	public void test01InsertScore() {
		System.out.printf("%s()%n", "testInsertScore");
		Score newScore = new Score(new Student(40001), new Subject(1), 80);
		int res = dao.insertScore(newScore);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectScoreByNo(newScore));
	}

	@Test
	public void test02UpdateScore() {
		System.out.printf("%s()%n", "testUpdateScore");
		Score newScore = new Score(new Student(40001), new Subject(1), 75);
		int res = dao.updateScore(newScore);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectScoreByNo(newScore));
	}

	@Test
	public void test03DeleteScore() {
		System.out.printf("%s()%n", "testDeleteScore");
		Score newScore = new Score(new Student(40001));
		int res = dao.deleteScore(newScore);
		Assert.assertEquals(1, res);
		dao.selectScoreByAll().stream().forEach(System.out::println);
	}

}
