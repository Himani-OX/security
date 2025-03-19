package com.example.springsecurity.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String homePage(HttpServletRequest httpServletRequest){
        return "Welcome to home page, this is a session id " + httpServletRequest.getRequestedSessionId();
    }
}
