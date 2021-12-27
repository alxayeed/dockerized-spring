package com.alxayeed.dockerized.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/home")
    public String home(){
        return "Hello from backend";
    }
}
