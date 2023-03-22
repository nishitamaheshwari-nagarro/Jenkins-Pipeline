package com.nagarro.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.userservice.entity.User;
import com.nagarro.userservice.service.UserService;

@RestController
@RequestMapping("/accounts")
public class RegisterController {

    @Autowired
    private UserService userService;
    
    @PostMapping(value = "/registration")
    public ResponseEntity<User> addUser(@RequestBody User user){
    	if(user != null)
    		try {
    			userService.saveUser(user);
    			return new ResponseEntity<User>(
    					user,
    					HttpStatus.CREATED);
    		}catch (Exception e) {
    			e.printStackTrace();
    			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }
    
}
