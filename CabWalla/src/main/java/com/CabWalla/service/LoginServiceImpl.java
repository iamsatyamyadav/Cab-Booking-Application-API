package com.CabWalla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CabWalla.exception.LoginException;
import com.CabWalla.model.LoginDTO;
import com.CabWalla.repository.AdminDao;
import com.CabWalla.repository.CurrentSessionDAO;
import com.CabWalla.repository.CustomerDao;
import com.CabWalla.repository.DriverDAO;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private AdminDao admindao;
	
	@Autowired
	private DriverDAO driverDAO;
	
	@Autowired
	private CurrentSessionDAO currentSessionDAO;
	

	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		return null;

	}
	

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}

}
