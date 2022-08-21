package com.booksstore.booksstore.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.booksstore.booksstore.model.Administrator;
import com.booksstore.booksstore.model.Client;
public interface AdministratorRepository  extends JpaRepository <Administrator, UUID> {
    @Query("select s from Client s where s.username=:username")
    Optional<Client> findByUserName(String username); 
}
