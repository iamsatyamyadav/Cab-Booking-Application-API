package com.CabWalla.controller;

import java.time.LocalDate;
import java.util.List;
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

import com.CabWalla.exception.AdminException;
import com.CabWalla.exception.CustomerException;
import com.CabWalla.exception.DriverException;
import com.CabWalla.exception.LoginException;
import com.CabWalla.exception.TripBookingException;
import com.CabWalla.model.Admin;
import com.CabWalla.model.Cab;
import com.CabWalla.model.Customer;
import com.CabWalla.model.Driver;
import com.CabWalla.model.TripBooking;
import com.CabWalla.service.AdminService;
import com.CabWalla.service.CabServices;
import com.CabWalla.service.CustomerService;
import com.CabWalla.service.DriverService;
import com.CabWalla.service.TripBookingService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TripBookingService tripBookingService;
	
	
	@Autowired
	private CabServices cabServices;

	@Autowired
	private DriverService driverService;



	@PostMapping("/addAdmins")
	public ResponseEntity<Admin> addAdmin(@Valid @RequestBody Admin admin) throws AdminException {

		Admin ad = adminService.insertAdmin(admin);

		return new ResponseEntity<Admin>(ad, HttpStatus.ACCEPTED);

	}

	@PutMapping("/updateAdmins")
	public ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin admin ,@RequestParam String key) throws AdminException {

		Admin ad = adminService.updateAdminDetails(admin, key);

		return new ResponseEntity<Admin>(ad, HttpStatus.ACCEPTED);

	}
	
	@DeleteMapping("/deleteAdmins/{aid}")
	public ResponseEntity<Admin> deleteAdmin(@PathVariable("aid") Integer adminId,@RequestParam String key) throws AdminException {

		Admin ad = adminService.deleteAdminDetails(adminId, key);

		return new ResponseEntity<Admin>(ad, HttpStatus.ACCEPTED);

	}

	@GetMapping("/admins/getAllcustomers")
	public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam String key) throws CustomerException, LoginException{
		
		List<Customer> customers = customerService.getAllCustomers(key);
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
		
	}
	
	@GetMapping("/admins/customerbyid/{cid}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("cid") Integer customerId, @RequestParam String key) throws CustomerException, LoginException{
		
		Customer customer = customerService.getCustomerById(customerId, key);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/admins/deletetrip/{tbid}/{uid}")
	public ResponseEntity<TripBooking> deletetrip(@PathVariable("tbid") Integer tbid,@PathVariable("uid") Integer uid,@RequestParam String key) throws TripBookingException, LoginException, AdminException{
		
		TripBooking tBooking = tripBookingService.deleteTripBooking(tbid, uid, key);
		
		
		return new ResponseEntity<TripBooking>(tBooking, HttpStatus.ACCEPTED);
	}

	@PutMapping("/admin/updateTrip/{userId}")
	public ResponseEntity<TripBooking> updateTrip(@PathVariable("userId") Integer userId, @RequestParam String key, @Valid @RequestBody TripBooking tripBook) throws TripBookingException, LoginException, AdminException{
		
		TripBooking trip = tripBookingService.updateTripBooking(tripBook, userId, key);
		
		return new ResponseEntity<TripBooking>(trip, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/admins/customers/getalltrip")
	public ResponseEntity<List<TripBooking>> getAllTrips(@RequestParam String key) throws CustomerException, AdminException{
		
		List<TripBooking> customersTrips = adminService.getAllTrips(key);
		
		
		return new ResponseEntity<List<TripBooking>>(customersTrips, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/admins/customer/getalltripofcustomer/{cid}")
	public ResponseEntity<List<TripBooking>> getAllTripsOfCustomers(@PathVariable("cid") Integer customerId,  @RequestParam String key) throws CustomerException, AdminException, TripBookingException, LoginException{
		
		List<TripBooking> customerTrips = adminService.getTripsByCustomerId(customerId, key);
		
		
		return new ResponseEntity<List<TripBooking>>(customerTrips, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/admins/getTrip/bydate/{date}")
	public ResponseEntity<Set<TripBooking>> getTripsDateWise(@PathVariable("date") String date, String key) throws CustomerException, TripBookingException, AdminException{
		
		LocalDate d = LocalDate.parse(date);
		
		Set<TripBooking> tripsByDate = adminService.getTripsDatewise(d, key);
		
		return new ResponseEntity<Set<TripBooking>>(tripsByDate, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/admins/getTrip/byday/{cid}/{sdate}/{edate}")
	public ResponseEntity<Set<TripBooking>> getAllTripsForDays(@PathVariable("cid") Integer customerId, @PathVariable("sdate") String sdate, @PathVariable("edate") String edate,String key) throws CustomerException, TripBookingException, AdminException{
		
		LocalDate startDate = LocalDate.parse(sdate);
		
		LocalDate endDate = LocalDate.parse(edate);
		
		Set<TripBooking> tripsByDate = adminService.getAllTripsForDays(customerId, startDate, endDate, key);
				
		
		return new ResponseEntity<Set<TripBooking>>(tripsByDate, HttpStatus.ACCEPTED);
	}

	
	@GetMapping("/admins/bestdrivers")
	public ResponseEntity<List<Driver>> viewBestDriver(@RequestParam String key){
		
		List<Driver> bestDrivers = driverService.viewBestDriver(key);
		
		return new ResponseEntity<List<Driver>>(bestDrivers, HttpStatus.OK);
		
	}
	
	
	
	@PutMapping("/admins/trip/getbill/{cid}")
	public ResponseEntity<TripBooking> getBill(@PathVariable("cid") Integer customerId, @RequestParam String key) throws CustomerException, TripBookingException, LoginException, AdminException{
		
		TripBooking trip = tripBookingService.calculateBill(customerId, key);
		
		return new ResponseEntity<TripBooking>(trip, HttpStatus.ACCEPTED);
		
	}
	

	@GetMapping("/admins/viewCabByType/{carType}")
	public ResponseEntity<List<Cab>> viewCabsOfType(@PathVariable("carType") String carType, @RequestParam String key) throws DriverException, LoginException{
		
		List<Cab> cabs = cabServices.viewCabsOfType(carType);
		
		return new ResponseEntity<List<Cab>>(cabs,HttpStatus.OK);
		
	}
	
	@GetMapping("/admins/countCabsOfType/{carType}")
	public ResponseEntity<Integer> countCabsOfType(@PathVariable("carType") String carType, @RequestParam String key) throws DriverException, LoginException{
		
		Integer count = cabServices.countCabsOfType(carType);
		
		return new ResponseEntity<Integer>(count,HttpStatus.OK);
	}

	
	
	@DeleteMapping("admins/deleteDriver/{driverId}")
	public ResponseEntity<Driver> deleteDriver(@PathVariable("driverId") Integer driverId, @RequestParam String key) throws DriverException{
		
		Driver deletedDriver = driverService.deleteDriver(driverId, key);
		
		return new ResponseEntity<Driver>(deletedDriver, HttpStatus.OK);
		
	}
	
	@GetMapping("admins/driver/{driverId}")
	public ResponseEntity<Driver> viewDriver(@PathVariable("driverId") Integer driverId, @RequestParam String key) throws DriverException, LoginException{
		
		Driver driver = driverService.viewDriver(driverId, key);
		
		return new ResponseEntity<Driver>(driver, HttpStatus.OK);

		
	}
}
