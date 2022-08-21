package com.booksstore.booksstore.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.booksstore.booksstore.model.Administrator;
public interface AdministratorRepository  extends JpaRepository <Administrator, UUID> {
    
}
