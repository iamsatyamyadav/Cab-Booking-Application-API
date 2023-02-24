package com.CabWalla.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity
public class Admin extends AbstractUser{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	public Admin(String userName, String password, String address, String mobileNo, String email, Integer adminId) {
		super(userName, password, address, mobileNo, email,adminId);
		this.adminId = adminId;
	}

	public Admin(String userName, String password, String address, String mobileNo, String email) {
		super(userName, password, address, mobileNo, email);
	}
	
	
	
}