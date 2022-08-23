package com.booksstore.booksstore.config;

import com.booksstore.booksstore.model.Administrator;
import com.booksstore.booksstore.repository.AdministratorRepository;
import com.booksstore.booksstore.service.AdministratorService;
import com.booksstore.booksstore.model.Client;

import javax.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import java.security.SecureRandom;

@Configuration
public class InitialAuthenticationConfig {
    @Autowired
    AdministratorRepository administratorRepository;
    @Autowired
    AdministratorService administratorService;

    @PostConstruct
    private void initializeUser() {
        if (administratorRepository.count() == 0) {
            Administrator administrator= new Administrator();
            Client client = new Client();
            client.setUsername("colaresm2018@gmail.com");
            
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());

            client.setPassword(bCryptPasswordEncoder.encode("993818"));
            administrator.setName("Marcelo Colares");
            administrator.setClient(client);

            administratorRepository.save(administrator);

        }
    
    }
}
