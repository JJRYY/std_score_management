package std_score_management.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import std_score_management.dao.StudentDetailDao;
import std_score_management.dto.Student;
import std_score_management.dto.StudentDetail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentDetailDaoImplTest {
	private StudentDetailDao dao = StudentDetailDaoImpl.getInstance();
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test02SelectStudentDetailByNo() {
		System.out.printf("%s()%n", "testSelectStudentDetailByNo");
		StudentDetail stdDetail = dao.selectStudentDetailByNo(new Student(20001));
		Assert.assertNotNull(stdDetail);
		System.out.println(stdDetail);
	}

	@Test
	public void test01InsertStudentDetail() {
		System.out.printf("%s()%n", "testInsertStudentDetail");
		
		StudentDetail stdDetail = new StudentDetail(20001, false, new Date(), getImage("이유리.jpg"));
		int res = dao.insertStudentDetail(stdDetail);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectStudentDetailByNo(new Student(20001)));
	}

	private byte[] getImage(String imgName) {
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir") + File.separator + "images", imgName);
		try(InputStream is = new FileInputStream(file)) {
			pic = new byte[is.available()];	//file로부터 읽은 이미지의 바이트 길이로 배열 생성
			is.read(pic);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}

	@Test
	public void test03UpdateStudentDetail() {
		System.out.printf("%s()%n", "testUpdateStudentDetail");
		
		StudentDetail stdDetail = new StudentDetail(20001, true, new Date(), getImage("조정석.jpg"));
		int res = dao.updateStudentDetail(stdDetail);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectStudentDetailByNo(new Student(20001)));
	}

	@Test
	public void test04DeleteStudentDetail() {
		System.out.printf("%s()%n", "testDeleteStudentDetail");
		Student newStd = new Student(20001);
		int res = dao.deleteStudentDetail(newStd);
		Assert.assertEquals(1, res);
	}

}
