package utility.testData.entities;

public class User {
	private final String id;
	private final String username;
	private final String pswd;

	public User(String id, String username, String pswd) {
		this.id = id;
		this.username = username;
		this.pswd = pswd;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPswd() {
		return pswd;
	}
}
