package com.team4.catalogbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team4.catalogbackend.model.DTDMapping;

@Repository
public interface DTDMappingRepository extends JpaRepository<DTDMapping, Long> {
}

