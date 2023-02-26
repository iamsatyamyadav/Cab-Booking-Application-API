package com.CabWalla.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Admin extends AbstractUser{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	public Admin(String userName, String password, String address, String mobileNo, String email, Integer adminId) {
		super(userName, password, address, mobileNo, email);
		this.adminId = adminId;
	}

	public Admin(String userName, String password, String address, String mobileNo, String email) {
		super(userName, password, address, mobileNo, email);
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Admin(Integer adminId) {
		super();
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + "]";
	}

	public Admin() {
		super();
	}

	
	
}