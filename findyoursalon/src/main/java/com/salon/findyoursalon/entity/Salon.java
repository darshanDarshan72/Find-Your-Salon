package com.salon.findyoursalon.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Salon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salon_id;

    @NotBlank
    private String salon_name;

    @NotBlank
    private String address;

    @OneToMany(mappedBy = "salon")
    private Set<Hairdresser> hairdressers;
}
