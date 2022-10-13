package com.salon.findyoursalon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.findyoursalon.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long>{
    
}
