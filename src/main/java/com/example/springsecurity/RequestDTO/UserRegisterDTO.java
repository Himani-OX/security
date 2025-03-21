package com.example.springsecurity.RequestDTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDTO {
    private String username;
    private String password;
    private String role;

}
