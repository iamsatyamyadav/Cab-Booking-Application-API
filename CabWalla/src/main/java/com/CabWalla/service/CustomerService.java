package com.CabWalla.service;

import java.util.List;

import com.CabWalla.exception.CustomerException;
import com.CabWalla.exception.LoginException;
import com.CabWalla.model.Customer;

public interface CustomerService {
	
public Customer insertCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer, String key) throws CustomerException;
	
	public Customer deleteCustomer(Integer customerId, String key) throws CustomerException, LoginException;
	
	public List<Customer> getAllCustomers(String key) throws CustomerException, LoginException;
	
	public Customer getCustomerById(Integer customerId, String key) throws CustomerException, LoginException;
	
	public Customer validateCustomer(String username, String password) throws CustomerException;

}
