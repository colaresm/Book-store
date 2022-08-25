package com.booksstore.booksstore.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.booksstore.booksstore.model.Address;
import com.booksstore.booksstore.model.Client;
import com.booksstore.booksstore.service.UserService;
import com.booksstore.booksstore.validation.UserValidation;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.booksstore.booksstore.model.User;
import com.booksstore.booksstore.model.enums.Position;
import com.booksstore.booksstore.dto.user.UserCreateRequest;
import com.booksstore.booksstore.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {
  
    private final UserRepository userRepository;

    private final UserValidation userValidation;


    @Autowired
    public UserServiceImpl( UserRepository userRepository, UserValidation userValidation) {
        this.userRepository = userRepository;
        this.userValidation= userValidation;
    }

    @Override
    public void create(UserCreateRequest userCreateRequest) {

        userValidation.validateForCreation(userCreateRequest);

        User userToCreate = new User();
        Address addressToCreate = new Address();
        Client clientToCreate = new Client();

        userToCreate.setName(userCreateRequest.getName());
        userToCreate.setCpf(userCreateRequest.getCpf());
        userToCreate.setBirthDate(userCreateRequest.getBirthDate());
        userToCreate.setEmail(userCreateRequest.getEmail());

        addressToCreate.setAddress(userCreateRequest.getAddressRequest().getAddress());
        addressToCreate.setCity(userCreateRequest.getAddressRequest().getCity());
        addressToCreate.setCep(userCreateRequest.getAddressRequest().getCep());
        addressToCreate.setState(userCreateRequest.getAddressRequest().getState());
        addressToCreate.setNeighborhood(userCreateRequest.getAddressRequest().getNeighborhood());
        addressToCreate.setComplement(userCreateRequest.getAddressRequest().getComplement());


        clientToCreate.setUsername(userCreateRequest.getClientCreateRequest().getUsername());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
        clientToCreate.setPassword(bCryptPasswordEncoder.encode(userCreateRequest.getClientCreateRequest().getPassword()));
        clientToCreate.setPosition(Position.USER);

        userToCreate.setAddress(addressToCreate);
        userToCreate.setClient(clientToCreate);
    

        
        userRepository.save(userToCreate);
    }

}
