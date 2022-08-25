package com.booksstore.booksstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.booksstore.booksstore.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    public AuthenticationServiceImpl(JwtTokenManager jwtTokenManager, UserDetailsService userDetailsService,
                                     UserService userService, ProfessionalService professionalService) {
        this.jwtTokenManager = jwtTokenManager;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
        this.professionalService = professionalService;
    }
}
