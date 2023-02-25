package com.CabWalla.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

   //@Data
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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Set<TripBooking> getTripBookings() {
		return tripBookings;
	}

	public void setTripBookings(Set<TripBooking> tripBookings) {
		this.tripBookings = tripBookings;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", tripBookings=" + tripBookings + "]";
	}

	public Customer(@Size(max = 15, min = 3) String userName,
			@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,12}$", message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit") String password,
			String address, @Pattern(regexp = "^[789]\\d{9}$") String mobileNo, @Email String email, Integer customerId,
			Set<TripBooking> tripBookings) {
		super(userName, password, address, mobileNo, email);
		this.customerId = customerId;
		this.tripBookings = tripBookings;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
