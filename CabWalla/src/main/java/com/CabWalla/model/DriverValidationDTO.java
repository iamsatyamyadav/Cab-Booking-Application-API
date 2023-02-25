package com.CabWalla.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DriverValidationDTO {

	
	private String userName;
	private String password;
	public DriverValidationDTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public DriverValidationDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	@Override
	public String toString() {
		return "DriverValidationDTO [userName=" + userName + ", password=" + password + "]";
	}
	
	
	
}
