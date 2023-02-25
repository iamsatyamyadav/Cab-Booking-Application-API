package com.CabWalla.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.CabWalla.exception.AdminException;
import com.CabWalla.exception.CustomerException;
import com.CabWalla.exception.DriverException;
import com.CabWalla.exception.TripBookingException;
import com.CabWalla.model.Admin;
import com.CabWalla.model.Cab;
import com.CabWalla.model.TripBooking;

public interface AdminService {
	
	public Admin insertAdmin(Admin admin)throws AdminException;
	
	public Admin updateAdminDetails(Admin admin,String key)throws AdminException;
	
	public Admin deleteAdminDetails(Integer adminId, String key)throws AdminException;
	
	public List<TripBooking> getAllTrips(String key)throws CustomerException,AdminException;
	
	public List<TripBooking> getTripsCabwise(Cab cab, String key) throws DriverException, AdminException;
	
	public List<TripBooking> getTripsByCustomerId(Integer customerId,String key)throws CustomerException,TripBookingException,AdminException;
	
	public Set<TripBooking> getTripsDatewise(LocalDate d,String key)throws CustomerException,TripBookingException,AdminException;
	 
	public Set<TripBooking> getAllTripsForDays(Integer customerId,LocalDate fromDate, LocalDate toDate, String key)throws CustomerException,TripBookingException,AdminException;

	
}
