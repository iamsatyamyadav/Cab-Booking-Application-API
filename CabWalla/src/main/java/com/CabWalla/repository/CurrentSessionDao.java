package com.CabWalla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CabWalla.model.CurrentSession;

@Repository
public interface CurrentSessionDao extends JpaRepository<CurrentSession, Integer>{

	public CurrentSession findByUuid(String uuid);
}