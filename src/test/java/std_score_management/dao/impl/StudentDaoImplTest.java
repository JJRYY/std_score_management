package std_score_management.dao.impl;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import std_score_management.dao.StudentDao;
import std_score_management.dto.Ban;
import std_score_management.dto.Student;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentDaoImplTest {
	private static StudentDao dao = StudentDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test04SelectStudentByAll() {
		System.out.printf("%s()%n", "testSelectStudentByAll");
		List<Student> stdList = dao.selectStudentByAll();
		Assert.assertNotNull(stdList);
		
		for(Student s : stdList) {
			System.out.println(s);
		}
	}

	@Test
	public void test05SelectStudentByNo() {
		System.out.printf("%s()%n", "testSelectStudentByNo");
		Student student = new Student(20001);
		Student searchStudent = dao.selectStudentByNo(student);
		Assert.assertNotNull(searchStudent);
		System.out.println(searchStudent);
	}

	@Test
	public void test01InsertStudent() {
		System.out.printf("%s()%n", "testInsertSubject");
		Student newStd = new Student(30001, "미포", new Ban("B01"));
		int res = dao.insertStudent(newStd);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectStudentByNo(newStd));
	}

	@Test
	public void test02UpdateStudent() {
		System.out.printf("%s()%n", "testUpdateStudent");
		Student newStd = new Student(30001, "멍청", new Ban("A01"));
		int res = dao.updateStudent(newStd);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectStudentByNo(newStd));
	}

	@Test
	public void test03DeleteStudent() {
		System.out.printf("%s()%n", "testDeleteStudent");
		Student newStd = new Student(30001);
		int res = dao.deleteStudent(newStd);
		Assert.assertEquals(1, res);
		dao.selectStudentByAll().stream().forEach(System.out::println);
	}

}
