package com.booksstore.booksstore.service;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import com.booksstore.booksstore.model.enums.Position;

import ch.qos.logback.core.net.server.Client;
public interface AuthenticationService {
    
    Authentication getAuthentication();


    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
    
    Map<String, String> payload(HttpServletRequest request, HttpServletResponse response) throws IOException;

    Boolean isClientLoggedWithPosition(Position position);

    UUID getClientIdLogged();

    Client getClientLogged();
}
