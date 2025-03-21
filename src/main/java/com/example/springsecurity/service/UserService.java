package com.example.springsecurity.service;

import com.example.springsecurity.RequestDTO.UserRegisterDTO;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with given " + username));
    }

    public void registerUser(UserRegisterDTO userRegisterDTO){
            if(userRepository.findByUsername(userRegisterDTO.getUsername()).isEmpty()){
                User user = new User();
                user.setUsername(userRegisterDTO.getUsername());
                user.setPassword(user.getPassword());
                user.setRole(user.getRole());
                userRepository.save(user);
            }else{
                throw new ResponseStatusException(HttpStatus.CONFLICT, "User Already exist");
            }
    }
}
