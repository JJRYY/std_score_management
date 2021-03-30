package std_score_management.dto;

import java.util.Arrays;
import java.util.Date;

public class StudentDetail {
	private int stdNo;
	private boolean gender;
	private Date enterDate;
	private byte[] stdPhoto;

	public StudentDetail() {
	}

	public StudentDetail(int stdNo) {
		this.stdNo = stdNo;
	}

	public StudentDetail(int stdNo, boolean gender, Date enterDate, byte[] stdPhoto) {
		this.stdNo = stdNo;
		this.gender = gender;
		this.enterDate = enterDate;
		this.stdPhoto = stdPhoto;
	}

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public byte[] getStdPhoto() {
		return stdPhoto;
	}

	public void setStdPhoto(byte[] stdPhoto) {
		this.stdPhoto = stdPhoto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stdNo;
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
		StudentDetail other = (StudentDetail) obj;
		if (stdNo != other.stdNo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("StudentDetail [stdNo=%s, gender=%s, enterDate=%s, stdPhoto=%s]", stdNo, gender, enterDate,
				Arrays.toString(stdPhoto));
	}

}
