package com.shipper.responses;

public class UserRegister {

	private String userName;
	private String password;
	private String email;
	
	public UserRegister() {}

	
	
	public UserRegister(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}



	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "UserRegister [userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}
	
}
