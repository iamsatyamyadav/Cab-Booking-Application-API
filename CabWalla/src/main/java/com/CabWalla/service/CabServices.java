package com.CabWalla.service;


import java.util.List;

import com.CabWalla.exception.DriverException;
import com.CabWalla.exception.LoginException;
import com.CabWalla.model.Cab;


public interface CabServices {

	public Cab updateCab(Cab cab) throws DriverException,LoginException;
	
	public List<Cab> viewCabsOfType(String carType) throws DriverException,LoginException;
	
	public int countCabsOfType(String carType) throws DriverException, LoginException;
}