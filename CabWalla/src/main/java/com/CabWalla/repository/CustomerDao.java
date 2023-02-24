package com.CabWalla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CabWalla.model.Customer;
import com.CabWalla.model.CustomerValidationDTO;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	public Customer findByUserName(String userName);
	
	
//	@Query("select new com.cabWalla.model.CustomerValidationDTO(c.userName,c.password) from Customer c")
//	public CustomerValidationDTO findCustomerUserNamePassword(String userName, String password);
}