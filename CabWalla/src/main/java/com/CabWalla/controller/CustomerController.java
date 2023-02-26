package com.CabWalla.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CabWalla.dto.CustomerValidationDTO;
import com.CabWalla.exception.AdminException;
import com.CabWalla.exception.CustomerException;
import com.CabWalla.exception.DriverException;
import com.CabWalla.exception.LoginException;
import com.CabWalla.exception.TripBookingException;
import com.CabWalla.model.Customer;
import com.CabWalla.model.Driver;
import com.CabWalla.model.TripBooking;
import com.CabWalla.service.CustomerService;
import com.CabWalla.service.DriverService;
import com.CabWalla.service.TripBookingService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TripBookingService tripbookService;
	
	@Autowired
	private DriverService driverService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer){
		
		Customer registeredCustomer  = customerService.insertCustomer(customer);
		
		return new ResponseEntity<Customer>(registeredCustomer, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer, @RequestParam String key){
		
		Customer updatedCustomer = customerService.updateCustomer(customer, key);
		
		return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/deleteCustomer/{cid}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("cid") Integer customerId, @RequestParam String key) throws CustomerException, LoginException{
		
		Customer deletedCustomer = customerService.deleteCustomer(customerId, key);
		
		return new ResponseEntity<Customer>(deletedCustomer, HttpStatus.OK);
		
	}
	

	
	@GetMapping("/customers/{cid}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("cid") Integer customerId, @RequestParam String key) throws CustomerException, LoginException{
		
		Customer customer = customerService.getCustomerById(customerId, key);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
	}
	
	@PostMapping("/customers/booktrip/{cid}")
	public ResponseEntity<TripBooking> bookTrip(@PathVariable("cid") Integer customerId ,@Valid @RequestBody TripBooking tripBook, @RequestParam String key) throws TripBookingException, LoginException{
		
		TripBooking tripBook1 = tripbookService.insertTripBooking(tripBook, customerId, key);
		
		
		return new ResponseEntity<TripBooking>(tripBook1, HttpStatus.OK);
	}
	
	@GetMapping("/validateCustomer")
	public ResponseEntity<Customer> validateCustomer(@Valid @RequestBody CustomerValidationDTO customerDto){
		
		String userName = customerDto.getUserName();
		String password = customerDto.getPassword(); 
		
		Customer customer = customerService.validateCustomer(userName, password);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@PutMapping("/customer/updateTrip/{userId}")
	public ResponseEntity<TripBooking> updateTrip(@PathVariable("userId") Integer userId, @RequestParam String key,@Valid @RequestBody TripBooking tripBook) throws TripBookingException, LoginException, AdminException{
		
		TripBooking trip = tripbookService.updateTripBooking(tripBook, userId, key);
		
		return new ResponseEntity<TripBooking>(trip, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/customer/tripbycustomer/{cid}")
	public ResponseEntity<Set<TripBooking>> getAllTripsOfCustomers(@PathVariable("cid") Integer customerId,  @RequestParam String key) throws CustomerException, AdminException, TripBookingException, LoginException{
		
		Set<TripBooking> customerTrips = tripbookService.viewAllTripsOfCustomerById(customerId, key);
		
		
		return new ResponseEntity<Set<TripBooking>>(customerTrips, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/customer/ratedriver")
	public ResponseEntity<Driver> rateDriver(@Valid @RequestBody Driver driver, @RequestParam String key) throws DriverException, LoginException{
		
		Driver ratedriver = driverService.rateDriverByCustomer(driver, key);
		
		return new ResponseEntity<Driver>(ratedriver, HttpStatus.ACCEPTED);
	}
}