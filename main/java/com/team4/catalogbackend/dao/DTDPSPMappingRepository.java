package com.team4.catalogbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team4.catalogbackend.model.DTDPSPMapping;

@Repository
public interface DTDPSPMappingRepository extends JpaRepository<DTDPSPMapping, Long> {
}

