package com.CabWalla.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Data

@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Driver extends AbstractUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer driverId;
	
	@NotNull
	@Column(unique = true)
	private String licenseNo;

	
	@Max(value=5,message = "Rating must be <= 5")
	@Min(value=0,message = "Rating must be more than 0")
	private Float rating;
	
	@Embedded
	private Cab cab;
	
	public Driver(String userName, String password, String address, String mobileNo, String email, Integer driverId,
			String licenseNo, Cab cab, Float rating) {
		super(userName, password, address, mobileNo, email);
		this.driverId = driverId;
		this.licenseNo = licenseNo;
		this.cab = cab;
		this.rating = rating;
	}

	public Driver(String userName, String password, String address, String mobileNo, String email, String licenseNo,
			Cab cab, Float rating) {
		super(userName, password, address, mobileNo, email);
		this.licenseNo = licenseNo;
		this.cab = cab;
		this.rating = rating;
	}
	
	
	
}