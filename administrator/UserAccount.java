package administrator;

public class UserAccount {
	private String username;
	private String password;
	
	public UserAccount(String u,String p) {
		// TODO Auto-generated constructor stub
		setUsername(u);
		setPassword(p);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
