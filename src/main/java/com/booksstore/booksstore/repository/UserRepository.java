package com.booksstore.booksstore.repository;


import java.util.UUID;

import com.booksstore.booksstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepository extends JpaRepository<User, UUID> {

}
