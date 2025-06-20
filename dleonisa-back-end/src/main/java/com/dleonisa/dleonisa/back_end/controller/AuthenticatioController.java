package com.dleonisa.dleonisa.back_end.controller;

import com.dleonisa.dleonisa.back_end.modelo.dto.AuthLogin;
import com.dleonisa.dleonisa.back_end.modelo.dto.AuthResponse;
import com.dleonisa.dleonisa.back_end.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticatioController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/log-in")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLogin userRequest){
        return  new ResponseEntity<>(this.usersService.loginUser(userRequest), HttpStatus.OK);
    }
}
