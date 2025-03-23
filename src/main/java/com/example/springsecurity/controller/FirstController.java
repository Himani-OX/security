package com.example.springsecurity.controller;


import com.example.springsecurity.RequestDTO.UserRegisterDTO;
import com.example.springsecurity.Urls;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FirstController {

    @Autowired
    UserService userService;

    @GetMapping("/custom-login")
    public String loginPage(){
        return "login";  //this calls login.html
    }

    @GetMapping(Urls.SIGNUP)
    public String signUp(){
        return "signup";  //signup.html will be called
    }

    @PostMapping(Urls.SIGNUP )
    public String register(@RequestBody UserRegisterDTO userRegisterDTO){
        userService.registerUser(userRegisterDTO);
        return "redirect:/login?registered";
    }

}
