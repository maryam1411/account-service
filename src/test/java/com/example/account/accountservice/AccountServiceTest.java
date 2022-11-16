package com.example.account.accountservice;

import com.example.account.domain.Account;
import com.example.account.exception.DuplicateUserName;
import com.example.account.service.account.AccountService;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class AccountServiceTest {

    private AccountService accountService;


    @BeforeEach
    public void setup() {
        this.accountService = Mockito.mock(AccountService.class);
    }


    @Test
    void saveTransactionInDatabase() throws DuplicateUserName, JSONException {
        Account entity = Account.builder()
                .firstName("maryam")
                .lastName("tanveer")
                .email("maryam@gmail.com")
                .password("1234")
                .phoneNumber("3333")
                .userName("maryam")
                .build();
        accountService.save(entity);
        // account information save in db we can verify by creating mock data don't need to hit the actual database

    }


    @Test
    void getTransactionInDatabase() {
        // we can mock data and then compare test should pass successfully
        Account entity = Account.builder()
                .firstName("maryam")
                .lastName("tanveer")
                .email("maryam@gmail.com")
                .password("1234")
                .phoneNumber("3333")
                .userName("maryam")
                .build();
        accountService.update(entity);

    }
}
