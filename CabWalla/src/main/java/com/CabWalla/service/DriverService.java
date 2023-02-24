package com.CabWalla.service;

import java.util.List;

import com.CabWalla.exception.DriverException;
import com.CabWalla.exception.LoginException;
import com.CabWalla.model.Driver;

public interface DriverService {
	public Driver insertDriver(Driver driver) throws DriverException;

	public Driver updateDriver(Driver driver,String key) throws DriverException;

	public Driver deleteDriver(Integer driverId,String key) throws DriverException;

	public List<Driver> viewBestDriver(String key) throws DriverException;

	public Driver viewDriver(Integer driverId,String key) throws DriverException, LoginException ;
	
	public Driver rateDriverByCustomer(Driver driver,String key)throws DriverException, LoginException;
}
