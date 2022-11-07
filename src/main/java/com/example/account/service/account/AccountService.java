package com.example.account.service.account;

import com.example.account.domain.Account;
import com.example.account.exception.DuplicateUserName;
import org.json.JSONException;

import java.util.Optional;

public interface AccountService {
    void save(Account account) throws DuplicateUserName, JSONException;

    void update(Account account);

    Optional<Account> findById(String id);

    Account findByUserName(String userName);

}
