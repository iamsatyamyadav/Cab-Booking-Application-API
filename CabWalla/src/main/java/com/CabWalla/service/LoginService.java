package com.CabWalla.service;

import com.CabWalla.dto.LoginDTO;
import com.CabWalla.exception.LoginException;

public interface LoginService {

	public String logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
