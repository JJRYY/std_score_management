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
	public String toString() {
		return String.format("Ban [banCode=%s]", banCode);
	}
}
