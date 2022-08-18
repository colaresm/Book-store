package com.booksstore.booksstore.service.impl;

import com.booksstore.booksstore.model.Address;
import com.booksstore.booksstore.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.booksstore.booksstore.model.User;
import com.booksstore.booksstore.dto.user.UserCreateRequest;
import com.booksstore.booksstore.repository.UserRepository;
import com.booksstore.booksstore.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }
    public void create(UserCreateRequest userCreateRequest) {
      //  userValidator.validateForCreation(examCreateRequest);

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

        userToCreate.setAddress(addressToCreate);
        userRepository.save(userToCreate);
    }

}
