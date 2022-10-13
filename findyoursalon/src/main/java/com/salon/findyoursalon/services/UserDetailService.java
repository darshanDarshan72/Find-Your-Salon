package com.salon.findyoursalon.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salon.findyoursalon.entity.Role;
import com.salon.findyoursalon.entity.User;
import com.salon.findyoursalon.enums.ERoles;
import com.salon.findyoursalon.repository.RoleRespository;
import com.salon.findyoursalon.repository.UserRepository;

@Service
public class UserDetailService implements UserDetail{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRespository roleRespository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        
        return this.userRepository.findAll();
    }

    @Override
    public String registerUser(@Valid User user) {
        
        Set<Role> roles = new HashSet<>();
        Role r = this.roleRespository.findByRole(ERoles.ROLE_USER).orElseThrow(() -> new RuntimeException("Role not found"));
        roles.add(r);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
        return "User Registered Successfully!!";
    }

    @Override
    public User getUser(Long user_id) {
        return this.userRepository.findById(user_id).orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    // @Override
    // public String updateUser(@Valid User user, @Valid Long user_id) {
    // }

    // @Override
    // public String deleteUser(Long user_id) {
    //     return null;
    // }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User Not Found"));
    }
    
}
