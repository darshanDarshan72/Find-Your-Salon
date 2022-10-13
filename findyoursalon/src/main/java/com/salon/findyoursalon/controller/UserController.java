package com.salon.findyoursalon.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.findyoursalon.entity.User;
import com.salon.findyoursalon.services.UserDetailService;

@RestController
@RequestMapping("/findmysalon/user")
public class UserController {

    @Autowired
    UserDetailService userService;


    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable Long user_id) {
        return ResponseEntity.ok(this.userService.getUser(user_id));
    }

    

}
