package com.CabWalla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CabWalla.DTO.DriverValidationDTO;
import com.CabWalla.model.Driver;

@Repository
public interface DriverDAO extends JpaRepository<Driver, Integer>{

	public Driver findByUserName(String userName);
	
//	@Query("select new com.cabway.model.DriverValidationDTO(d.userName,d.password) from Driver d")
//	public DriverValidationDTO findDriverUserNamePassword(String userName, String password);

}