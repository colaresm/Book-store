package com.booksstore.booksstore.controller;

import com.booksstore.booksstore.controller.docs.ManagerControllerDocs;
import com.booksstore.booksstore.dto.manager.ManagerCreateRequest;
import com.booksstore.booksstore.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@RequestMapping(value = "/managers")
public class ManagersController implements ManagerControllerDocs{
    private final ManagerService managerService;
    @Autowired
    public ManagersController(ManagerService managerService) {
        this.managerService = managerService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid ManagerCreateRequest managerCreateRequest) {

        managerService.create(managerCreateRequest);
    }
}
