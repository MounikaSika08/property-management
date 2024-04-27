package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.service.UserService;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService service;
    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDto){
        logger.info("In the register() method");

        UserDTO dto = service.register(userDto);
        ResponseEntity<UserDTO> response = new ResponseEntity<>(dto, HttpStatus.CREATED);
        return response;
    }
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@Valid @RequestBody UserDTO userDto){
        UserDTO dto = service.login(userDto.getOwnerEmail(), userDto.getPassword());
        ResponseEntity<UserDTO> response = new ResponseEntity<>(dto, HttpStatus.CREATED);
        return response;
    }
}
