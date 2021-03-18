package std_score_management.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import std_score_management.dao.SubjectDao;
import std_score_management.dto.Subject;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubjectDaoImplTest {
	private static SubjectDao dao = SubjectDaoImpl.getInstance();
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test04SelectSubjectByAll() {
		System.out.printf("%s()%n", "testSelectSubjectByAll");
		List<Subject> subjectList = dao.selectSubjectByAll();
		Assert.assertNotNull(subjectList);
		
		for(Subject s : subjectList) {
			System.out.println(s);
		}
	}

	@Test
	public void test05SelectSubjectByNo() {
		System.out.printf("%s()%n", "testSelectSubjectByNo");
		Subject subject = new Subject(101);
		Subject searchSubject = dao.selectSubjectByNo(subject);
		Assert.assertNotNull(searchSubject);
		System.out.println(searchSubject);
	}

	@Test
	public void test01InsertSubject() {
		System.out.printf("%s()%n", "testInsertSubject");
		Subject newSubject = new Subject(601, "기계");
		int res = dao.insertSubject(newSubject);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectSubjectByNo(newSubject));
	}

	@Test
	public void test02UpdateSubject() {
		System.out.printf("%s()%n", "testUpdateSubject");
		Subject newSubject = new Subject(601, "전자");
		int res = dao.updateSubject(newSubject);
		System.out.println(dao.selectSubjectByNo(newSubject));
	}

	@Test
	public void test03DeleteSubject() {
		System.out.printf("%s()%n", "testDeleteSubject");
		Subject newSubject = new Subject(601);
		int res = dao.deleteSubject(newSubject);
		Assert.assertEquals(1, res);
		dao.selectSubjectByAll().stream().forEach(System.out::println);
	}

}
