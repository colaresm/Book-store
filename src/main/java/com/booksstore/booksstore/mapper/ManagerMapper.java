package com.booksstore.booksstore.mapper;

import com.booksstore.booksstore.dto.manager.ManagerCreateRequest;
import com.booksstore.booksstore.dto.user.UserCreateRequest;
import com.booksstore.booksstore.model.Manager;
import com.booksstore.booksstore.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManagerMapper {
    Manager toModel(ManagerCreateRequest managerCreateRequest);
}
