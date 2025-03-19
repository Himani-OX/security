package com.example.springsecurity.configuration;

import com.example.springsecurity.Urls;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain getAuthenticationConfiguration(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(Urls.BASE_URL + Urls.VERSION + Urls.LOGIN ,
                                                Urls.BASE_URL + Urls.VERSION + Urls.SIGNUP).permitAll()
                        .anyRequest().authenticated()
                        )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }




}
