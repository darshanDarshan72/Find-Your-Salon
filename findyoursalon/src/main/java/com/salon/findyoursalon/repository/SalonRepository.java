package com.salon.findyoursalon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.findyoursalon.entity.Salon;

@Repository
public interface SalonRepository extends JpaRepository<Salon,Long>{
    
}
