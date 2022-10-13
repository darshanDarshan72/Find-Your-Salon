package com.salon.findyoursalon.dto;

import java.util.Set;

import com.salon.findyoursalon.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private boolean status;
    
    private Long user_id;
    private String user_name;
    private String password;
    private String email;
    private String phone;
    private Set<Role> roles;
}
