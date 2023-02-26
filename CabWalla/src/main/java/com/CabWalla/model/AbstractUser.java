package com.CabWalla.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@MappedSuperclass
public abstract class AbstractUser {


	public AbstractUser() {
		super();
	}

	@Size(max = 15, min = 3)
	@Column(unique = true)
	private String userName;

	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$", message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit")
	private String password;
	
	private String address;
	
	@Pattern(regexp = "^[789]\\d{9}$")
	private String mobileNo;
	
	@Email
	private String email;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AbstractUser(@Size(max = 15, min = 3) String userName,
			@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$", message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit") String password,
			String address, @Pattern(regexp = "^[789]\\d{9}$") String mobileNo, @Email String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	@Override
	public String toString() {
		return "AbstractUser [userName=" + userName + ", password=" + password + ", address=" + address + ", mobileNo="
				+ mobileNo + ", email=" + email + "]";
	}
	

	
}