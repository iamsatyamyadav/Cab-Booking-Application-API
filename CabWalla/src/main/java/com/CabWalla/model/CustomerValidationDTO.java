package com.CabWalla.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerValidationDTO {

	@NotNull(message = "field cant be empty")
	@Size(max = 15, min = 3, message = "Username must be between 3 to 15 characters")
	private String userName;
	
	@NotNull(message = "field cant be empty")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$", message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit")
	private String password;

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

	public CustomerValidationDTO(
			@NotNull(message = "field cant be empty") @Size(max = 15, min = 3, message = "Username must be between 3 to 15 characters") String userName,
			@NotNull(message = "field cant be empty") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$", message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit") String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public CustomerValidationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
