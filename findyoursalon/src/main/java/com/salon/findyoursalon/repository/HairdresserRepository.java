package com.salon.findyoursalon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.findyoursalon.entity.Hairdresser;

@Repository
public interface HairdresserRepository extends JpaRepository<Hairdresser,Long>{
    
}
