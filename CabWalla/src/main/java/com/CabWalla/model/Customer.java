package com.CabWalla.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


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

	public Integer getCustomerId() {
		return customerId;
	}

	public Set<TripBooking> getTripBookings() {
		return tripBookings;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public void setTripBookings(Set<TripBooking> tripBookings) {
		this.tripBookings = tripBookings;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", tripBookings=" + tripBookings + "]";
	}

	public Customer(Integer customerId, Set<TripBooking> tripBookings) {
		super();
		this.customerId = customerId;
		this.tripBookings = tripBookings;
	}

	public Customer() {
		super();
	}
	
	
	
	
}
