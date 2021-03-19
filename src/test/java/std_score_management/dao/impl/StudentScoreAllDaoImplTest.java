package std_score_management.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import std_score_management.dao.StudentScoreAllDao;
import std_score_management.dto.Student;
import std_score_management.dto.StudentScoreAll;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentScoreAllDaoImplTest {
	private StudentScoreAllDao dao = StudentScoreAllDaoImpl.getInstance(); 
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testSelectStudentScoreAll() {
		System.out.printf("%s()%n", "testSelectStudentScoreAll");
		List<StudentScoreAll> stdList = dao.selectStudentScoreAll();
		Assert.assertNotNull(stdList);
		for (StudentScoreAll s : stdList) {
			System.out.println(s);
		}
	}

	@Test
	public void testSelectStudentScoreByNo() {
		System.out.printf("%s()%n", "testSelectStudentByNo");
		StudentScoreAll stdScoreAll = dao.selectStudentScoreByNo(new Student(20001));
		Assert.assertNotNull(stdScoreAll);
		System.out.println(stdScoreAll);
	}

}
