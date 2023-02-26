package com.CabWalla.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CabWalla.dto.LoginDTO;
import com.CabWalla.exception.LoginException;
import com.CabWalla.service.LoginService;

@RestController
public class LoginLogoutController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@Valid @RequestBody LoginDTO dto) throws LoginException{
		
		String s = loginService.logIntoAccount(dto);
		
		return new ResponseEntity<String>(s, HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		
		String s= loginService.logOutFromAccount(key);
		
		return new ResponseEntity<String>(s, HttpStatus.OK);
		
		
		
	}
}
