package com.CabWalla.service;

import java.util.Set;

import com.CabWalla.exception.AdminException;
import com.CabWalla.exception.CustomerException;
import com.CabWalla.exception.LoginException;
import com.CabWalla.exception.TripBookingException;
import com.CabWalla.model.TripBooking;

public interface TripBookingService {
	
	public TripBooking insertTripBooking(TripBooking tripBook, Integer customerId, String key)throws TripBookingException, LoginException;
	
	public TripBooking updateTripBooking(TripBooking tripBook,Integer userId, String key)throws TripBookingException, LoginException, AdminException;
	
	public TripBooking deleteTripBooking(Integer tbId,Integer userId, String key)throws TripBookingException, LoginException, AdminException;
	
	public Set<TripBooking> viewAllTripsOfCustomerById(Integer customerId,String key)throws TripBookingException,CustomerException, LoginException;
	
	public TripBooking calculateBill(Integer tripBookingId, String key)throws TripBookingException,CustomerException, LoginException, AdminException;
	
}
