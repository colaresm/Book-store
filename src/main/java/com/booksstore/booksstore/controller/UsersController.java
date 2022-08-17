package com.booksstore.booksstore.controller;

import com.booksstore.booksstore.dto.user.UserCreateRequest;
import com.booksstore.booksstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import com.booksstore.booksstore.controller.docs.UserControllerDocs;
@RestController
@RequestMapping(value = "/users")
public class UsersController implements UserControllerDocs{
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid UserCreateRequest userCreateRequest) {
        userService.create(userCreateRequest);
    }
}
