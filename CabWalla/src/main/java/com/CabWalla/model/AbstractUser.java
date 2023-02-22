package com.CabWalla.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data

@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
public abstract class AbstractUser {

	@NotNull(message = "This field can't be empty")
	@Size(max = 15, min = 3)
	@Column(unique = true)
	private String userName;
	
	@NotNull(message = "This field can't be empty")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$", message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit")
	private String password;
	
	@NotNull(message = "This field can't be empty")
	private String address;
	
	@NotNull(message = "This field can't be empty")
	@Pattern(regexp = "^[789]\\d{9}$")
	private String mobileNo;
	
	@NotNull(message = "This field can't be empty")
	@Email
	private String email;
	

	
}