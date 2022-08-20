package com.booksstore.booksstore.service.impl;

import com.booksstore.booksstore.dto.manager.ManagerCreateRequest;
import com.booksstore.booksstore.mapper.ManagerMapper;
import com.booksstore.booksstore.model.Address;
import com.booksstore.booksstore.model.Client;
import com.booksstore.booksstore.model.Manager;
import com.booksstore.booksstore.repository.ManagerRepository;
import com.booksstore.booksstore.service.ManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public class ManagerServiceImpl implements ManagerService{
    private final ManagerMapper managerMapper;
    private final ManagerRepository managerRepository;

  //  private final Manage userValidation;
  @Autowired
  public ManagerServiceImpl(ManagerMapper managerMapper, ManagerRepository managerRepository) {
      this.managerMapper = managerMapper;
      this.managerRepository = managerRepository;
      //this.userValidation= userValidation;


  }
    @Override
    public void create(ManagerCreateRequest managerCreateRequest) {

       // userValidation.validateForCreation(userCreateRequest);

        Manager managerToCreate = new Manager();
        Address addressToCreate = new Address();
        Client clientToCreate = new Client();

        managerToCreate.setName(managerCreateRequest.getName());
        managerToCreate.setCpf(managerCreateRequest.getCpf());
        managerToCreate.setBirthDate(managerCreateRequest.getBirthDate());
        managerToCreate.setEmail(managerCreateRequest.getEmail());

        addressToCreate.setAddress(managerCreateRequest.getAddressRequest().getAddress());
        addressToCreate.setCity(managerCreateRequest.getAddressRequest().getCity());
        addressToCreate.setCep(managerCreateRequest.getAddressRequest().getCep());
        addressToCreate.setState(managerCreateRequest.getAddressRequest().getState());
        addressToCreate.setNeighborhood(managerCreateRequest.getAddressRequest().getNeighborhood());
        addressToCreate.setComplement(managerCreateRequest.getAddressRequest().getComplement());


        clientToCreate.setUsername(managerCreateRequest.getClientCreateRequest().getUsername());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
        clientToCreate.setPassword(bCryptPasswordEncoder.encode(managerCreateRequest.getClientCreateRequest().getPassword()));

        managerToCreate.setAddress(addressToCreate);
        managerToCreate.setClient(clientToCreate);

        managerRepository.save(managerToCreate);
    }
}
