package com.c174.controllers;

import com.c174.exception.AlreadyExistsException;
import com.c174.models.user.UserRequest;
import com.c174.models.user.UserResponse;
import com.c174.services.abstraccion.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        return new ResponseEntity<List<UserResponse>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserRequest user) throws AlreadyExistsException  {
        try{
            return new ResponseEntity<UserResponse>(userService.createUser(user), HttpStatus.OK);
        } catch (AlreadyExistsException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
