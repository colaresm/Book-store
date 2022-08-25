package com.booksstore.booksstore.model.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Position {
    USER("User"),
    ADMINISTRATOR("Administratorr");

    private String value;
}