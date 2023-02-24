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

import com.CabWalla.exception.DriverException;
import com.CabWalla.exception.LoginException;
import com.CabWalla.model.Driver;
import com.CabWalla.service.DriverService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/d")
public class DriverController {
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
	
}
