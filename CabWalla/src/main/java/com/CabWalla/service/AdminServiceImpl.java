package com.CabWalla.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CabWalla.exception.AdminException;
import com.CabWalla.exception.CustomerException;
import com.CabWalla.exception.DriverException;
import com.CabWalla.exception.TripBookingException;
import com.CabWalla.model.Admin;
import com.CabWalla.model.Cab;
import com.CabWalla.model.CurrentSession;
import com.CabWalla.model.Customer;
import com.CabWalla.model.TripBooking;
import com.CabWalla.repository.AdminDao;
import com.CabWalla.repository.CurrentSessionDao;
import com.CabWalla.repository.CustomerDao;
import com.CabWalla.repository.TripBookingDao;



@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao aDao;

	@Autowired
	private CurrentSessionDao csDao;

	@Autowired
	private CustomerDao cDao;

	@Autowired
	private TripBookingDao tbDao;
	
	@Override
	public Admin insertAdmin(Admin admin) throws AdminException {
		Admin existingAdmin = aDao.findByUserName(admin.getUserName());

		if (existingAdmin != null) {
			throw new AdminException("Admin already present with username: " + admin.getUserName());
		} else {
			Admin saveadmin = aDao.save(admin);
			return saveadmin;
		}
	}

	@Override
	public Admin updateAdminDetails(Admin admin, String key) throws AdminException {
		CurrentSession adminLogin = csDao.findByUuid(key);

		if (adminLogin == null) {
			throw new AdminException("Please provide a valid key to update a Admin");
		}

		if (admin.getAdminId() == adminLogin.getUserId()) {
			return aDao.save(admin);
		} else {
			throw new AdminException("Invalid Admin details ,please login first");
		}
	}

	@Override
	public Admin deleteAdminDetails(Integer adminId, String key) throws AdminException {
		CurrentSession adminLogin = csDao.findByUuid(key);

		if (adminLogin == null) {
			throw new AdminException("Please provide a valid key to delete a Admin");
		}

		if (adminId == adminLogin.getUserId()) {
			Admin existingAdmin = aDao.findById(adminId).orElseThrow(() -> new AdminException("Admin not found"));
			aDao.delete(existingAdmin);

			return existingAdmin;
		} else {
			throw new AdminException("Invalid Admin details ,please login first");
		}
	}

	@Override
	public List<TripBooking> getAllTrips(String key) throws CustomerException, AdminException {

		CurrentSession adminLogin = csDao.findByUuid(key);

		if (adminLogin == null) {
			throw new AdminException("Please provide a valid key to get all trips of customers");
		} else {
			List<TripBooking> customerTrips = tbDao.findAll();

			if (customerTrips.size() > 0) {

				return customerTrips;
			} else {
				throw new CustomerException("No trip is present.");
			}

		}
	}

	@Override
	public List<TripBooking> getTripsCabwise(Cab cab, String key) throws DriverException, AdminException {
		CurrentSession adminLogin = csDao.findByUuid(key);

		if (adminLogin == null) {
			throw new AdminException("Please provide a valid key to get all trips of customers");
		} else {

			List<TripBooking> cabWiseTrips = new ArrayList<>();

			for (TripBooking trips : tbDao.findAll()) {

				if (trips.getDriver().getCab().getCabId() == cab.getCabId()) {

					cabWiseTrips.add(trips);

				}

			}

			if (cabWiseTrips.size() == 0) {

				throw new DriverException("No trips found for driver with cab " + cab.getCabId());

			} else {
				return cabWiseTrips;
			}

		}
	}
	

	@Override
	public List<TripBooking> getTripsByCustomerId(Integer customerId, String key)
			throws CustomerException, TripBookingException, AdminException {
		CurrentSession adminLogin = csDao.findByUuid(key);

		if (adminLogin == null) {
			throw new AdminException("Please provide a valid key to get all trips of customers");
		} else {

			Customer c = cDao.findById(customerId)
					.orElseThrow(() -> new CustomerException("Customer not find with cid :" + customerId));

			Set<TripBooking> customertrips = c.getTripBookings();

			List<TripBooking> customerTrips = new ArrayList<>(customertrips);

			if (customerTrips.size() > 0) {
				return customerTrips;
			} else {
				throw new TripBookingException("No trips found for customer " + customerId);
			}

		}
	}

	@Override
	public Set<TripBooking> getTripsDatewise(LocalDate date, String key)
			throws CustomerException, TripBookingException, AdminException {
		CurrentSession adminLogin = csDao.findByUuid(key);

		if (adminLogin == null) {
			throw new AdminException("Please provide a valid key to get all trips of customers");
		} else {

			List<TripBooking> trips = tbDao.findAll();

			if (trips.size() > 0) {

				Set<TripBooking> dateWiseTrips = new HashSet<>();

				for (TripBooking tb : trips) {


					
					LocalDate startdate = tb.getFromDateTime().toLocalDate();
					
					if (startdate.equals(date)) {
						dateWiseTrips.add(tb);
					}

				}

				if (dateWiseTrips.size() == 0) {
					throw new TripBookingException("No trips present found for date" + date);
				} else {
					return dateWiseTrips;
				}

			} else {
				throw new TripBookingException("Trips not available. ");
			}

		}
	}

	@Override
	public Set<TripBooking> getAllTripsForDays(Integer customerId, LocalDate fromDate, LocalDate toDate, String key)
			throws CustomerException, TripBookingException, AdminException {
		CurrentSession adminLogin = csDao.findByUuid(key);

		if (adminLogin == null) {
			throw new AdminException("Please provide a valid key to get all trips of customers");
		} else {

			List<TripBooking> trips = tbDao.findAll();

			if (trips.size() > 0) {

				Set<TripBooking> allTrips = new HashSet<>();

				for (TripBooking tb : trips) {

					LocalDate startdate = tb.getFromDateTime().toLocalDate();
					
					LocalDate enddate = tb.getToDateTime().toLocalDate();

					if (startdate.isEqual(fromDate) && enddate.isEqual(toDate)) {

						allTrips.add(tb);

					}

				}
				if (allTrips.size() == 0) {
					throw new TripBookingException(
							"No trips present found for staetdate: " + fromDate + " to ennDate: " + toDate);
				} else {
					return allTrips;
				}

			} else {
				throw new CustomerException("No one customer is present");
			}

		}
	}
	

}
