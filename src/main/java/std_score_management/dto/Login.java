package std_score_management.dto;

public class Login {
	private String id;
	private String passwd;
	private String email;

	public Login() {
	}

	public Login(String id) {
		this.id = id;
	}

	public Login(String id, String passwd) {
		this.id = id;
		this.passwd = passwd;
	}

	public Login(String id, String passwd, String email) {
		this.id = id;
		this.passwd = passwd;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("Login [id=%s, passwd=%s, email=%s]", id, passwd, email);
	}

}
