package com.example.account.handler;

import com.example.account.Transformer.AccountTransformer;
import com.example.account.domain.Account;
import com.example.account.exception.DuplicateUserName;
import com.example.account.model.AccountModel;
import com.example.account.service.account.AccountService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountHandler {
    private final AccountService accountService;
    private final AccountTransformer accountTransformer;

    @Autowired
    public AccountHandler(AccountService accountService, AccountTransformer accountTransformer) {
        this.accountService = accountService;
        this.accountTransformer = accountTransformer;
    }

    public void save(AccountModel accountModel) throws DuplicateUserName, JSONException {
        accountService.save(accountTransformer.toEntity(accountModel));
    }

    public void updateAccountRegistration(String id, AccountModel accountModel) {
        Optional<Account> accountRegistration = accountService.findById(id);
        accountRegistration.ifPresent(registration -> accountService.update(updateAccountRegistration(registration, accountModel)));

    }

    private Account updateAccountRegistration(Account account, AccountModel accountModel) {
        account.setEmail(accountModel.getEmail());
        account.setFirstName(accountModel.getFirstName());
        account.setLastName(accountModel.getLastName());
        account.setUserName(accountModel.getUserName());
        account.setPhoneNumber(accountModel.getPhoneNumber());
        account.setPassword(accountModel.getPassword());
        return account;

    }

    public AccountModel getRegisteredAccount(String userName) {
        Account account = accountService.findByUserName(userName);
        return accountTransformer.toModel(account);
    }
}
