package com.salon.findyoursalon.services;

import java.util.List;

import javax.validation.Valid;

import com.salon.findyoursalon.entity.User;

public interface UserDetail {

    public List<User> getAllUsers();
    public String registerUser(@Valid User user);
    public User getUser(Long user_id);
    //public String updateUser(@Valid User user, @Valid Long user_id);
    // public String deleteUser(Long user_id);
    public User getUserByUsername(String username);
    
}
