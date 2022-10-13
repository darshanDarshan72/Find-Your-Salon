package com.salon.findyoursalon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.salon.findyoursalon.entity.Role;
import com.salon.findyoursalon.enums.ERoles;

@Repository
public interface RoleRespository extends JpaRepository<Role,Long>{

    Optional<Role> findByRole(ERoles roles);
}
