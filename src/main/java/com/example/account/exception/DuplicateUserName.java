package com.example.account.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuplicateUserName extends Exception {

    public static final String MESSAGE = "User name already registered";

    public DuplicateUserName() {
        super(MESSAGE);


    }
}
