package com.booksstore.booksstore.service;

import com.booksstore.booksstore.dto.user.UserCreateRequest;

public interface UserService {
    void create(UserCreateRequest userCreateRequest);
}
