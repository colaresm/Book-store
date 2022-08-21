package com.booksstore.booksstore.controller;

import com.booksstore.booksstore.controller.docs.AdministratorControllerDocs;
import com.booksstore.booksstore.dto.administrator.AdministratorCreateRequest;
import com.booksstore.booksstore.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping(value = "/administrators")
public class AdministratorsController implements AdministratorControllerDocs{
    private final AdministratorService administratorService;

    @Autowired
    public AdministratorsController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid AdministratorCreateRequest administratorCreateRequest) {

        administratorService.create(administratorCreateRequest);
    }
}
