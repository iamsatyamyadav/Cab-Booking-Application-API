package com.CabWalla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CabWalla.exception.AdminException;
import com.CabWalla.exception.CustomerException;
import com.CabWalla.exception.DriverException;
import com.CabWalla.exception.LoginException;
import com.CabWalla.exception.TripBookingException;
import com.CabWalla.model.Cab;
import com.CabWalla.model.Driver;
import com.CabWalla.model.TripBooking;
import com.CabWalla.service.CabServices;
import com.CabWalla.service.DriverService;
import com.CabWalla.service.TripBookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/d")
public class DriverController {
	

	@Autowired
	private TripBookingService tbService;
	
	@Autowired
	private CabServices cabService;
	
	@Autowired
	private DriverService driverService;

	@PostMapping("/driver")
	public ResponseEntity<Driver> registerDriver(@Valid @RequestBody Driver driver){
		
		Driver saved  = driverService.insertDriver(driver);
		
		return new ResponseEntity<Driver>(saved, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateDriver")
	public ResponseEntity<Driver> updateDriver(@Valid @RequestBody Driver driver, @RequestParam String key){
		
		Driver updatedDriver = driverService.updateDriver(driver, key);
		
		return new ResponseEntity<Driver>(updatedDriver, HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/deleteDriver/{driverId}")
	public ResponseEntity<Driver> deleteDriver(@PathVariable("driverId") Integer driverId, @RequestParam String key) throws DriverException{
		
		Driver deletedDriver = driverService.deleteDriver(driverId, key);
		
		return new ResponseEntity<Driver>(deletedDriver, HttpStatus.OK);
		
	}
	
	@GetMapping("/driver/{driverId}")
	public ResponseEntity<Driver> viewDriver(@PathVariable("driverId") Integer driverId, @RequestParam String key) throws DriverException, LoginException{
		
		Driver viewdriver = driverService.viewDriver(driverId, key);
		
		return new ResponseEntity<Driver>(viewdriver, HttpStatus.OK);
		
	}
	@PutMapping("/driver/updateTripBooking/{userId}")
	public ResponseEntity<TripBooking> updateTrip(@PathVariable("userId") Integer userId, @RequestParam String key,@Valid @RequestBody TripBooking tripBook) throws TripBookingException, LoginException, AdminException{
		
		TripBooking trip = tbService.updateTripBooking(tripBook, userId, key);
		
		return new ResponseEntity<TripBooking>(trip, HttpStatus.ACCEPTED);
		
	}
	

	@PutMapping("/drivers/updateCab")
	public ResponseEntity<Cab> updateCab(@Valid @RequestBody Cab cab, @RequestParam String key) throws DriverException, LoginException{
		
		Cab updatedCab = cabService.updateCab(cab);
		
		return new ResponseEntity<Cab>(updatedCab, HttpStatus.ACCEPTED);
	}

	
	@PutMapping("/driver/tripbooking/bill/{customerid}")
	public ResponseEntity<TripBooking> calculateBillHandler(@PathVariable("customerid") Integer customerid, @RequestParam String key) throws DriverException, LoginException, CustomerException, TripBookingException, AdminException{
		
		TripBooking trip = tbService.calculateBill(customerid, key);
		
		return new ResponseEntity<TripBooking>(trip, HttpStatus.OK);
		
	}
	
}
