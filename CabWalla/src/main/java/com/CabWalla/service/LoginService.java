package com.CabWalla.service;

import com.CabWalla.exception.LoginException;
import com.CabWalla.model.LoginDTO;

public interface LoginService {

	public String logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
