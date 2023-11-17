package com.team4.catalogbackend.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team4.catalogbackend.model.DTMapping;
import com.team4.catalogbackend.model.Domain;

@Repository
public interface DTMappingRepository extends JpaRepository<DTMapping, Long> {

	List<DTMapping> findByDomain(Domain domain);
}