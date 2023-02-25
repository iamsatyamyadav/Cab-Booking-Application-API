package com.CabWalla.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

   @Getter
   @Setter
   @ToString
   @AllArgsConstructor
   @NoArgsConstructor
   @Entity
   public class Customer extends AbstractUser{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private Set<TripBooking> tripBookings = new HashSet<>();

	public Customer(String userName, String password, String address, String mobileNo, String email,
			Integer customerId) {
		super(userName, password, address, mobileNo, email);
		this.customerId = customerId;
	}

	public Customer(String userName, String password, String address, String mobileNo, String email) {
		super(userName, password, address, mobileNo, email);
	}
	
	
	
	
}
