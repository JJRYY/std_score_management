package std_score_management.dto;

import java.util.Date;

public class Student {
	private int stdNo; 		//학번
	private String stdName;	//학생명
	private int stdGrade;	//학년
	private Ban banCode;	//분반
	private Date enterDate;	//입학날짜
	
//	private String photoName;	// 사진이름
//	private Blob stdPhoto;		// 학생사진

	public Student() {
	}

	public Student(int stdNo) {
		this.stdNo = stdNo;
	}

	public Student(int stdNo, String stdName) {
		this.stdNo = stdNo;
		this.stdName = stdName;
	}

	public Student(int stdNo, String stdName, int stdGrade, Ban banCode, Date enterDate) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdGrade = stdGrade;
		this.banCode = banCode;
		this.enterDate = enterDate;
	}

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getStdGrade() {
		return stdGrade;
	}

	public void setStdGrade(int stdGrade) {
		this.stdGrade = stdGrade;
	}

	public Ban getBanCode() {
		return banCode;
	}

	public void setBanCode(Ban banCode) {
		this.banCode = banCode;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	@Override
	public String toString() {
		return String.format("Student [stdNo=%s, stdName=%s, stdGrade=%s, banCode=%s, enterDate=%s]", stdNo, stdName,
				stdGrade, banCode, enterDate);
	}

}
