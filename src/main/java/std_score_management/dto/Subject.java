package std_score_management.dto;

public class Subject {
	private int subjectCode;
	private String subjectName;

	public Subject() {
	}

	public Subject(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Subject(int subjectCode, String subjectName) {
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return String.format("Subject [subjectCode=%s, subjectName=%s]", subjectCode, subjectName);
	}

}
