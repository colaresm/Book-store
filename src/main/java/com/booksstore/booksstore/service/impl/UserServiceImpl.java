package com.booksstore.booksstore.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.booksstore.booksstore.model.Address;
import com.booksstore.booksstore.model.Client;
import com.booksstore.booksstore.service.UserService;
import com.booksstore.booksstore.validation.UserValidation;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.booksstore.booksstore.model.User;
import com.booksstore.booksstore.dto.user.UserCreateRequest;
import com.booksstore.booksstore.repository.UserRepository;
import com.booksstore.booksstore.mapper.UserMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    private final UserValidation userValidation;


    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository, UserValidation userValidation) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.userValidation= userValidation;

    }
    @Override

    public void create(UserCreateRequest userCreateRequest) {

        userValidation.validateForCreation(userCreateRequest);

        User userToCreate = new User();
        Address addressToCreate = new Address();

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

        Client clientToCreate = new Client();
        clientToCreate.setUsername(userToCreate.getClient().getUsername());
        clientToCreate.setPassword(userToCreate.getClient().getPassword());

        userToCreate.setAddress(addressToCreate);
        userToCreate.setClient(clientToCreate);
        System.out.println(userToCreate);
        userRepository.save(userToCreate);
    }

}
