package com.CabWalla.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CabWalla.dto.LoginDTO;
import com.CabWalla.exception.LoginException;
import com.CabWalla.model.Admin;
import com.CabWalla.model.CurrentSession;
import com.CabWalla.model.Customer;
import com.CabWalla.model.Driver;
import com.CabWalla.repository.AdminDao;
import com.CabWalla.repository.CurrentSessionDao;
import com.CabWalla.repository.CustomerDao;
import com.CabWalla.repository.DriverDao;

@Service
public class LoginServiceImpl implements LoginService {


	@Autowired
	private DriverDao driverDao;

	@Autowired
	private CurrentSessionDao currentSessionDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private AdminDao admindao;
	
	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {

		String type = dto.getUserType();

		if (type.equals("customer")) {
			Customer existingCustomer = customerDao.findByUserName(dto.getUserName());

			if (existingCustomer == null)
				throw new LoginException("Please enter a valid username ");

			Optional<CurrentSession> validUserSessionOpt = currentSessionDao.findById(existingCustomer.getCustomerId());

			if (validUserSessionOpt.isPresent()) {
				throw new LoginException("User already logged in..");
			}

			if (!existingCustomer.getPassword().equals(dto.getPassword())) {
				throw new LoginException("Please enter a valid password ");
			}

			UUID randomUUID = UUID.randomUUID();
			String key = randomUUID.toString().split("-")[0];

			CurrentSession userSession = new CurrentSession(existingCustomer.getCustomerId(), key, LocalDateTime.now());

			currentSessionDao.save(userSession);

			return userSession.toString();

		} else if (type.equals("admin")) {
			Admin existingAdmin = admindao.findByUserName(dto.getUserName());

			if (existingAdmin == null)
				throw new LoginException("Please enter a valid username ");

			Optional<CurrentSession> validUserSessionOpt = currentSessionDao.findById(existingAdmin.getAdminId());

			if (validUserSessionOpt.isPresent()) {
				throw new LoginException("User already logged in..");
			}

			if (!existingAdmin.getPassword().equals(dto.getPassword())) {
				throw new LoginException("Please enter a valid password ");

			}

			UUID randomUUID = UUID.randomUUID();
			String key = randomUUID.toString().split("-")[0];

			CurrentSession userSession = new CurrentSession(existingAdmin.getAdminId(), key, LocalDateTime.now());

			currentSessionDao.save(userSession);

			return userSession.toString();

		} else if (type.equals("driver")) {

			Driver existingDriver = driverDao.findByUserName(dto.getUserName());

			if (existingDriver == null)
				throw new LoginException("Please enter a valid username ");

			Optional<CurrentSession> validUserSessionOpt = currentSessionDao.findById(existingDriver.getDriverId());

			if (validUserSessionOpt.isPresent()) {
				throw new LoginException("User already logged in..");
			}

			if (!existingDriver.getPassword().equals(dto.getPassword())) {
				throw new LoginException("Please enter a valid password ");
			}
			UUID randomUUID = UUID.randomUUID();
			String key = randomUUID.toString().split("-")[0];

			CurrentSession userSession = new CurrentSession(existingDriver.getDriverId(), key, LocalDateTime.now());

			currentSessionDao.save(userSession);

			return userSession.toString();

		}

		else
			return "Usertype should be admin or customer or driver..";

	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		CurrentSession vs = currentSessionDao.findByUuid(key);
		
		if(vs==null) {
			throw new LoginException("No user found with key " + key);
		}else {
			
			currentSessionDao.delete(vs);
			
			return "Logged Out!";
		}
	}

}
