package com.CabWalla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CabWalla.model.CurrentSession;

public interface CurrentSessionDAO extends JpaRepository<CurrentSession, Integer>{

	public  CurrentSession  findByUuid(String uuid);
}