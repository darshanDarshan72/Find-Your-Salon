package com.salon.findyoursalon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salon.findyoursalon.dto.LoginRequest;
import com.salon.findyoursalon.dto.LoginResponse;
import com.salon.findyoursalon.entity.User;
import com.salon.findyoursalon.services.UserDetailService;

@RestController
@RequestMapping("/findmysalon")
public class AuthController {

    @Autowired
    UserDetailService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest)
    {
        User user= this.userService.getUserByUsername(loginRequest.getUsername());
        if(passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
        {
            LoginResponse loginResponse = new LoginResponse();

            loginResponse.setStatus(true);
            loginResponse.setUser_id(user.getUser_id());
            loginResponse.setUser_name(user.getUsername());
            loginResponse.setEmail(user.getEmail());
            loginResponse.setPhone(user.getPhone());
            loginResponse.setPassword(user.getPassword());
            loginResponse.setRoles(user.getRoles());

            return ResponseEntity.ok(loginResponse);
        }
        else{
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setStatus(false);
            return ResponseEntity.ok(loginResponse);
        }
        
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(this.userService.registerUser(user));
    }
    
}
