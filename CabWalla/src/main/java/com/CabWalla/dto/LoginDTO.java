package com.CabWalla.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



public class LoginDTO {

	@NotNull(message = "Field cannot be empty.")
	@Size(max = 15, min = 3, message = "Username should be between 3 to 15 characters")
	private String userName;
	
	@NotNull(message = "Field cannot be empty.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$", message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit")
	private String password;
	
	@NotNull(message = "Field cannot be empty.")
	private String userType;

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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public LoginDTO() {
		super();
	}

	public LoginDTO(
			@NotNull(message = "Field cannot be empty.") @Size(max = 15, min = 3, message = "Username should be between 3 to 15 characters") String userName,
			@NotNull(message = "Field cannot be empty.") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$", message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit") String password,
			@NotNull(message = "Field cannot be empty.") String userType) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "LoginDTO [userName=" + userName + ", password=" + password + ", userType=" + userType + "]";
	}
	
	
}
 