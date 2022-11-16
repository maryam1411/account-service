package com.example.account.Transformer;

import com.example.account.domain.Account;
import com.example.account.model.AccountModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountTransformer implements Transformer<AccountModel, Account> {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private String encodePassword(String password) {
        return encoder.encode(password);

    }

    @Override
    public Account toEntity(AccountModel accountModel) {
        return Account.builder()
                .id(UUID.randomUUID())
                .firstName(accountModel.getFirstName())
                .lastName(accountModel.getLastName())
                .userName(accountModel.getUserName())
                .email(accountModel.getEmail())
                .phoneNumber(accountModel.getPhoneNumber())
                .password(encodePassword(accountModel.getPassword()))
                .build();

    }

    @Override
    public AccountModel toModel(Account account) {
        return AccountModel.builder()
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .userName(account.getUserName())
                .email(account.getEmail())
                .phoneNumber(account.getPhoneNumber())
                .password(account.getPassword())
                .build();

    }
}
