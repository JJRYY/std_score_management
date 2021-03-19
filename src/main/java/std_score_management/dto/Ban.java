package std_score_management.dto;

public class Ban {
	private String banCode;

	public Ban() {
	}

	public Ban(String banCode) {
		this.banCode = banCode;
	}

	public String getBanCode() {
		return banCode;
	}

	public void setBanCode(String banCode) {
		this.banCode = banCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((banCode == null) ? 0 : banCode.hashCode());
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
		Ban other = (Ban) obj;
		if (banCode == null) {
			if (other.banCode != null)
				return false;
		} else if (!banCode.equals(other.banCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s", banCode);
	}
}
