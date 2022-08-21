package com.booksstore.booksstore.exception.administrator;

import javax.persistence.EntityExistsException;
public class AdministratorAlreadyExistsException extends EntityExistsException{
    public AdministratorAlreadyExistsException(String field, String value) {
        super(String.format("Administrador com %s %s já existe.", field, value));
    }
}
