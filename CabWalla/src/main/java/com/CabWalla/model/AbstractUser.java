package com.CabWalla.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
public abstract class AbstractUser {

//	@NotNull(message = "This field should not be null.")
	@Size(max = 15, min = 3, message = "Username should be between 3 to 15 characters")
	@Column(unique = true)
	private String userName;
	
//	@NotNull(message = "This field should not be null.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$", message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit")
	private String password;
	
//	@NotNull(message = "This field should not be null.")
	private String address;
	
//	@NotNull(message = "This field should not be null.")
	@Pattern(regexp = "^[789]\\d{9}$")
	private String mobileNo;
	
//	@NotNull(message = "This field should not be null.")
	@Email
	private String email;
	

	
}
