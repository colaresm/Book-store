package com.booksstore.booksstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.booksstore.booksstore.dto.administrator.AdministratorCreateRequest;
import com.booksstore.booksstore.model.Administrator;
import com.booksstore.booksstore.model.Client;
import com.booksstore.booksstore.repository.AdministratorRepository;
import com.booksstore.booksstore.service.AdministratorService;
import com.booksstore.booksstore.validation.AdministratorValidation;

import java.security.SecureRandom;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdministratorServiceImpl implements AdministratorService{
   
    private final AdministratorRepository administratorRepository;
    
    private final AdministratorValidation administratorValidation;
    @Autowired
    public AdministratorServiceImpl(AdministratorRepository administratorRepository,AdministratorValidation administratorValidation) {
     
        this.administratorRepository = administratorRepository;
        this.administratorValidation=administratorValidation;
    }
    @Override
    public void create(AdministratorCreateRequest administratorCreateRequest) {

        administratorValidation.validateForCreation(administratorCreateRequest);

        Administrator administratorToCreate = new Administrator();
        Client clientToCreate = new Client();

        administratorToCreate.setName(administratorCreateRequest.getName());
      
        clientToCreate.setUsername(administratorCreateRequest.getClientCreateRequest().getUsername());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
        clientToCreate.setPassword(bCryptPasswordEncoder.encode(administratorCreateRequest.getClientCreateRequest().getPassword()));

       
        administratorToCreate.setClient(clientToCreate);

        administratorRepository.save(administratorToCreate);
    }


}
