package std_score_management.dto;

public class Score {
	private Student stdNo;
	private Subject subjectCode;
	private int stdScore;

	public Score() {
	}

	public Score(Student stdNo) {
		this.stdNo = stdNo;
	}

	public Score(Student stdNo, Subject subjectCode, int stdScore) {
		this.stdNo = stdNo;
		this.subjectCode = subjectCode;
		this.stdScore = stdScore;
	}

	public Student getStdNo() {
		return stdNo;
	}

	public void setStdNo(Student stdNo) {
		this.stdNo = stdNo;
	}

	public Subject getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(Subject subjectCode) {
		this.subjectCode = subjectCode;
	}

	public int getStdScore() {
		return stdScore;
	}

	public void setStdScore(int stdScore) {
		this.stdScore = stdScore;
	}

	@Override
	public String toString() {
		return String.format("Score [stdNo=%s, subjectCode=%s, stdScore=%s]", 
				stdNo, subjectCode, stdScore);
	}

}
