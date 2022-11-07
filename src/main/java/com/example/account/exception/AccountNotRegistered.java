package com.example.account.exception;

public class AccountNotRegistered extends Exception {
    public static final String MESSAGE = "Account not registered";


    public AccountNotRegistered() {
        super(MESSAGE);
    }
}
