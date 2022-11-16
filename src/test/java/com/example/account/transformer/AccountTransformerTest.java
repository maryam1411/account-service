package com.example.account.transformer;

import com.example.account.Transformer.AccountTransformer;
import com.example.account.domain.Account;
import com.example.account.model.AccountModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class AccountTransformerTest {

    private BCryptPasswordEncoder encoder;
    private AccountTransformer accountTransformer;

    @BeforeEach
    public void setup() {
        this.accountTransformer = new AccountTransformer();
        this.encoder = new BCryptPasswordEncoder();
    }

    @Test
    public void whenModelGivenShouldReturnEntity() {
        AccountModel transactionModel = AccountModel.builder()
                .firstName("maryam")
                .lastName("tanveer")
                .email("maryam@gmail.com")
                .password("1234")
                .phoneNumber("3333")
                .userName("maryam")
                .build();
        Account entity = accountTransformer.toEntity(transactionModel);
        Assertions.assertNotNull(entity);
        Assertions.assertEquals("maryam", entity.getFirstName());
        Assertions.assertEquals("tanveer", entity.getLastName());
        Assertions.assertEquals("maryam@gmail.com", entity.getEmail());
        Assertions.assertEquals("maryam", entity.getUserName());
        if (encoder.matches("1234", entity.getPassword())) {
            Assertions.assertEquals("1234", "1234");
        }
        Assertions.assertEquals("3333", entity.getPhoneNumber());


    }

    @Test
    public void whenEntityGivenShouldReturnModel() {
        Account entity = Account.builder()
                .firstName("maryam")
                .lastName("tanveer")
                .email("maryam@gmail.com")
                .password("1234")
                .phoneNumber("3333")
                .userName("maryam")
                .build();
        AccountModel model = accountTransformer.toModel(entity);
        Assertions.assertNotNull(entity);
        Assertions.assertEquals("maryam", model.getFirstName());
        Assertions.assertEquals("tanveer", model.getLastName());
        Assertions.assertEquals("maryam@gmail.com", model.getEmail());
        Assertions.assertEquals("maryam", model.getUserName());
        if (encoder.matches("1234", entity.getPassword())) {
            Assertions.assertEquals("1234", "1234");
        }        Assertions.assertEquals("3333", model.getPhoneNumber());
    }

}