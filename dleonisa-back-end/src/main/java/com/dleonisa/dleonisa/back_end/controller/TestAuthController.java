package com.dleonisa.dleonisa.back_end.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/method")
public class TestAuthController {

    @PreAuthorize("permitAll()")
    @GetMapping("/get")
    public String helloGet(){
        return "Hello Wo - GET";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/post")
    public String helloPost(){
        return "Hello World - POST";
    }

    @PutMapping("/put")
    public String helloPut(){
        return "Hello World - PUT";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'CAJERO')")
    @DeleteMapping("/delete")
    public String helloDelete(){
        return "Hello World - DELETE";
    }

    @PreAuthorize("hasAnyRole('DEVELOPER')")
    @PatchMapping("/patch")
    public String helloPatch(){
        return "Hello World - PATCH";
    }
}
