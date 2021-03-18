package std_score_management.dto;

public class Student {
	private int stdNo; 		//학번
	private String stdName;	//학생명
	private Ban banCode;	//분반
	
	public Student() {
	}

	public Student(int stdNo) {
		this.stdNo = stdNo;
	}

	public Student(int stdNo, String stdName) {
		this.stdNo = stdNo;
		this.stdName = stdName;
	}

	public Student(int stdNo, String stdName, Ban banCode) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.banCode = banCode;
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

	public Ban getBanCode() {
		return banCode;
	}

	public void setBanCode(Ban banCode) {
		this.banCode = banCode;
	}

	@Override
	public String toString() {
		return String.format("Student [stdNo=%s, stdName=%s, banCode=%s]", stdNo, stdName, banCode);
	}


}
