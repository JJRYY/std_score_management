package std_score_management.dto;

public class StudentScoreAll {
// stdNo, stdName, banCode, kor, eng, math, soc, sci
	private Student stdNo;
	private String stdName;
	private Ban banCode;
	private int kor;
	private int eng;
	private int math;
	private int soc;
	private int sci;
	
	public StudentScoreAll() {
	}

	public StudentScoreAll(Student stdNo) {
		this.stdNo = stdNo;
	}

	public StudentScoreAll(Student stdNo, int kor, int eng, int math, int soc, int sci) {
		this.stdNo = stdNo;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.soc = soc;
		this.sci = sci;
	}

	public StudentScoreAll(Student stdNo, String stdName, Ban banCode, int kor, int eng, int math, int soc, int sci) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.banCode = banCode;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.soc = soc;
		this.sci = sci;
	}

	public Student getStdNo() {
		return stdNo;
	}

	public void setStdNo(Student stdNo) {
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

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSoc() {
		return soc;
	}

	public void setSoc(int soc) {
		this.soc = soc;
	}

	public int getSci() {
		return sci;
	}

	public void setSci(int sci) {
		this.sci = sci;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stdNo == null) ? 0 : stdNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentScoreAll other = (StudentScoreAll) obj;
		if (stdNo == null) {
			if (other.stdNo != null)
				return false;
		} else if (!stdNo.equals(other.stdNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"StudentScoreAll [stdNo=%s, stdName=%s, banCode=%s, kor=%s, eng=%s, math=%s, soc=%s, sci=%s]", stdNo,
				stdName, banCode, kor, eng, math, soc, sci);
	}
	
	
	
}
