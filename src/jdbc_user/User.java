package jdbc_user;

public class User {
	private int id;
	private String name;
	private long number;
	private String emailId;
	private String password;
	private String facebookPassword;
	private String instagramPassword;
	private String xPassword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFacebookPassword() {
		return facebookPassword;
	}

	public void setFacebookPassword(String facebookPassword) {
		this.facebookPassword = facebookPassword;
	}

	public String getInstagramPassword() {
		return instagramPassword;
	}

	public void setInstagramPassword(String instagramPassword) {
		this.instagramPassword = instagramPassword;
	}

	public String getxPassword() {
		return xPassword;
	}

	public void setxPassword(String xPassword) {
		this.xPassword = xPassword;
	}

}
