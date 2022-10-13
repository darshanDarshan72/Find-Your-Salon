package com.salon.findyoursalon.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hairdresser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hairdresser_id;

    @NotBlank
    private String hairdresser_name;

    
    @ManyToOne
    @JoinColumn(name="salon_id",nullable=true)
    private Salon salon;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "hairdresser_services" , 
    joinColumns = @JoinColumn(name = "hairdresser_id"),
    inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<Service> services;
}
