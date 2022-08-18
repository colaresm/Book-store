package com.booksstore.booksstore.validation;

import java.util.Objects;

import com.booksstore.booksstore.dto.user.UserCreateRequest;
import com.booksstore.booksstore.exception.user.UserAlreadyExistsException;
import com.booksstore.booksstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")

@Component
public class UserValidation {
    @Autowired
    private UserRepository userRepository;

    public void validateForCreation(UserCreateRequest userCreateRequest) {
        validateCPF(userCreateRequest.getCpf());
        validateEmail(userCreateRequest.getEmail());
    }
    private void validateCPF(String cpf) {
        userRepository.findByCpf(cpf).ifPresent(user -> {
            throw new UserAlreadyExistsException("CPF", cpf); });
    }
    private void validateEmail(String email) {
        userRepository.findByEmail(email).ifPresent(user -> {
            throw new UserAlreadyExistsException("e-mail", email); });
    }
}
