package std_score_management.dto;

public class Subject {
	private int subjectCode;
	private String subjectName;

	public Subject() {
	}

	public Subject(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Subject(String subjectName) {
		this.subjectName = subjectName;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + subjectCode;
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
		Subject other = (Subject) obj;
		if (subjectCode != other.subjectCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s(%s)", subjectName, subjectCode);
	}

}
