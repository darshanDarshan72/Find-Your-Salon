package com.salon.findyoursalon.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Salon {
    
    private Long salon_id;
    private String salon_name;
    private String address;
}
