package com.CabWalla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CabWalla.model.TripBooking;

public interface TripBookingDao extends JpaRepository<TripBooking, Integer> {
	

}
