package com.CabWalla.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class TripBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tripBookingId;
	
	private Integer customerId;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Driver driver;
	
//	@NotNull(message = "This field cannot be empty")
	private String fromLocation;
	
//	@NotNull(message = "This field cannot be empty")
	private String toLocation;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
	private LocalDateTime fromDateTime;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
	private LocalDateTime toDateTime;
	
	private boolean status;
	
//	@NotNull(message = "This field cannot be null")
	private Float distanceInKm;
	
	private Float bill;
	
	
}