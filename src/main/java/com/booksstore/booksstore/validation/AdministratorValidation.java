package com.booksstore.booksstore.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.booksstore.booksstore.dto.administrator.AdministratorCreateRequest;
import com.booksstore.booksstore.exception.administrator.AdministratorAlreadyExistsException;
import com.booksstore.booksstore.repository.AdministratorRepository;

@SuppressWarnings("unused")

@Component
public class AdministratorValidation {
    @Autowired
    private AdministratorRepository administratorRepository;
    public void validateForCreation(AdministratorCreateRequest administratorCreateRequest) {
       
        validateUserName(administratorCreateRequest.getClientCreateRequest().getUsername());
    }
    private void validateUserName(String username) {
        administratorRepository.findByUserName(username).ifPresent(user -> {
            throw new AdministratorAlreadyExistsException("Username", username); });
    }
}
