package com.CabWalla.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CabWalla.exception.CustomerException;
import com.CabWalla.exception.DriverException;
import com.CabWalla.exception.LoginException;
import com.CabWalla.model.CurrentSession;
import com.CabWalla.model.Driver;
import com.CabWalla.repository.AdminDao;
import com.CabWalla.repository.CurrentSessionDao;
import com.CabWalla.repository.DriverDao;

@Service
public class DriverServiceImpl implements DriverService {
	@Autowired
	private DriverDao driverDao;

	@Autowired
	private CurrentSessionDao currentSessionDao;

	@Autowired
	private AdminDao adminDao;

	@Override
	public Driver insertDriver(Driver driver) throws DriverException {

		Driver existDriver = driverDao.findByUserName(driver.getUserName());

		if (existDriver != null)
			throw new CustomerException("Driver Registered with user ID ");

		return driverDao.save(driver);
	}

	@Override
	public Driver updateDriver(Driver driver, String key) throws DriverException {

		CurrentSession user = currentSessionDao.findByUuid(key);

		if (user == null) {
			throw new DriverException("Please enter a valid key to update driver");
		}

		if (driver.getDriverId() == user.getUserId()) {

			return driverDao.save(driver);
		} else
			throw new DriverException("login to continue");

	}

	@Override
	public Driver deleteDriver(Integer driverId, String key) throws DriverException {

		CurrentSession user = currentSessionDao.findByUuid(key);

		Integer value = user.getUserId();

		if (driverDao.findById(value).isPresent()) {
			if (driverId == value) {

				Driver existingDriver = driverDao.findById(driverId)
						.orElseThrow(() -> new DriverException("Invalid driverId."));

				currentSessionDao.delete(user);

				driverDao.delete(existingDriver);

				return existingDriver;
			} else {
				throw new DriverException("Invalid Id.");
			}
		} else if (adminDao.findById(value).isPresent()) {
			Driver existingDriver = driverDao.findById(driverId)
					.orElseThrow(() -> new DriverException("Invalid driverId."));

			currentSessionDao.delete(user);

			driverDao.delete(existingDriver);

			return existingDriver;
		} else {
			throw new IllegalArgumentException("Invalid user Id entered.");
		}
	}

	@Override
	public List<Driver> viewBestDriver(String key) throws DriverException {
		CurrentSession adminValidate = currentSessionDao.findByUuid(key);

		if (adminValidate == null) {
			throw new DriverException("Please enter a valid key to update driver");
		} else {

			List<Driver> alldrivers = driverDao.findAll();

			List<Driver> drivers = new ArrayList<>();

			for (Driver driver : alldrivers) {

				if (driver.getRating() >= 4.5) {

					drivers.add(driver);

				}

			}

			if (drivers.isEmpty()) {
				throw new DriverException("No drivers found rating above 4.5 ");

			}
			return drivers;

		}
	}

	@Override
	public Driver viewDriver(Integer driverId, String key) throws DriverException, LoginException {
		CurrentSession user = currentSessionDao.findByUuid(key);

		if (user == null)
			throw new LoginException("Please log in first");

		if (driverDao.findById(user.getUserId()).isPresent()) {
			if (driverId == user.getUserId()) {

				Driver existingDriver = driverDao.findById(driverId)
						.orElseThrow(() -> new DriverException("Invalid driverId."));
				return existingDriver;
			} else {
				throw new CustomerException("Invalid customer Id.");
			}
		} else if (adminDao.findById(user.getUserId()).isPresent()) {

			Driver existingDriver = driverDao.findById(driverId)
					.orElseThrow(() -> new DriverException("Invalid driverId."));
			return existingDriver;

		} else {
			throw new IllegalArgumentException("Invalid user Id ");
		}
	}

	@Override
	public Driver rateDriverByCustomer(Driver driver, String key) throws DriverException, LoginException {
		CurrentSession user = currentSessionDao.findByUuid(key);

		if (user == null)
			throw new LoginException("Please log in first");
		else {

			Driver ratedriver = driverDao.findById(driver.getDriverId())
					.orElseThrow(() -> new DriverException("No driver found"));

			if (ratedriver.getRating() != 0) {

				Float newRating = (driver.getRating() + ratedriver.getRating()) / 2;

				ratedriver.setRating(newRating);

				return driverDao.save(ratedriver);

			} else {

				ratedriver.setRating(driver.getRating());

				return driverDao.save(ratedriver);

			}

		}
	}
	

}