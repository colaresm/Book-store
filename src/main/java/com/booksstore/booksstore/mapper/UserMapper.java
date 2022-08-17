package com.booksstore.booksstore.mapper;


import com.booksstore.booksstore.dto.user.UserCreateRequest;
import com.booksstore.booksstore.model.User;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toModel(UserCreateRequest userCreateRequest);
}
