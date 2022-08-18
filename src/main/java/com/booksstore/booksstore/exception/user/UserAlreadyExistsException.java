package com.booksstore.booksstore.exception.user;

import javax.persistence.EntityExistsException;

public class UserAlreadyExistsException  extends EntityExistsException {
    public UserAlreadyExistsException(String field, String value) {
        super(String.format("Usuário com %s %s já existe.", field, value));
    }
}

