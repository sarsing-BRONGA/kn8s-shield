package com.k8.challenge.kn8sshield.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Hackathon";
    }
}
