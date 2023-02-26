package com.CabWalla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CabWalla.dto.CustomerValidationDTO;
import com.CabWalla.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	public Customer findByUserName(String userName);
	
	
	@Query("select new com.CabWalla.dto.CustomerValidationDTO(c.userName,c.password) from Customer c")
	public CustomerValidationDTO findCustomerUserNamePassword(String userName, String password);
}