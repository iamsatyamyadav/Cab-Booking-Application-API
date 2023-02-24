package com.CabWalla.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CabWalla.exception.LoginException;
import com.CabWalla.model.Admin;
import com.CabWalla.model.CurrentSession;
import com.CabWalla.model.Customer;
import com.CabWalla.model.Driver;
import com.CabWalla.model.LoginDTO;
import com.CabWalla.repository.AdminDao;
import com.CabWalla.repository.CurrentSessionDAO;
import com.CabWalla.repository.CustomerDao;
import com.CabWalla.repository.DriverDAO;

@Service
public class LoginServiceImpl implements LoginService {


	@Autowired
	private DriverDAO driverDAO;

	@Autowired
	private CurrentSessionDAO currentSessionDAO;

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

			Optional<CurrentSession> validUserSessionOpt = currentSessionDAO.findById(existingCustomer.getCustomerId());

			if (validUserSessionOpt.isPresent()) {
				throw new LoginException("User already logged in..");
			}

			if (!existingCustomer.getPassword().equals(dto.getPassword())) {
				throw new LoginException("Please enter a valid password ");
			}

			UUID randomUUID = UUID.randomUUID();
			String key = randomUUID.toString().split("-")[0];

			CurrentSession userSession = new CurrentSession(existingCustomer.getCustomerId(), key, LocalDateTime.now());

			currentSessionDAO.save(userSession);

			return userSession.toString();

		} else if (type.equals("admin")) {
			Admin existingAdmin = admindao.findByUserName(dto.getUserName());

			if (existingAdmin == null)
				throw new LoginException("Please enter a valid username ");

			Optional<CurrentSession> validUserSessionOpt = currentSessionDAO.findById(existingAdmin.getAdminId());

			if (validUserSessionOpt.isPresent()) {
				throw new LoginException("User already logged in..");
			}

			if (!existingAdmin.getPassword().equals(dto.getPassword())) {
				throw new LoginException("Please enter a valid password ");

			}

			UUID randomUUID = UUID.randomUUID();
			String key = randomUUID.toString().split("-")[0];

			CurrentSession userSession = new CurrentSession(existingAdmin.getAdminId(), key, LocalDateTime.now());

			currentSessionDAO.save(userSession);

			return userSession.toString();

		} else if (type.equals("driver")) {

			Driver existingDriver = driverDAO.findByUserName(dto.getUserName());

			if (existingDriver == null)
				throw new LoginException("Please enter a valid username ");

			Optional<CurrentSession> validUserSessionOpt = currentSessionDAO.findById(existingDriver.getDriverId());

			if (validUserSessionOpt.isPresent()) {
				throw new LoginException("User already logged in..");
			}

			if (!existingDriver.getPassword().equals(dto.getPassword())) {
				throw new LoginException("Please enter a valid password ");
			}
			UUID randomUUID = UUID.randomUUID();
			String key = randomUUID.toString().split("-")[0];

			CurrentSession userSession = new CurrentSession(existingDriver.getDriverId(), key, LocalDateTime.now());

			currentSessionDAO.save(userSession);

			return userSession.toString();

		}

		else
			return "Usertype should be admin or customer or driver..";

	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		CurrentSession vs = currentSessionDAO.findByUuid(key);
		
		if(vs==null) {
			throw new LoginException("No user found with key " + key);
		}else {
			
			currentSessionDAO.delete(vs);
			
			return "Logged Out!";
		}
	}

}
