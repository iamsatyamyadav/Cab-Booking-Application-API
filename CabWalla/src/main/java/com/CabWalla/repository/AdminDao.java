package com.CabWalla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CabWalla.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{

	public Admin findByUserName(String userName);
}