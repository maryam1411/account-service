package com.example.account.service.account;

import com.example.account.domain.Account;
import com.example.account.exception.DuplicateUserName;
import org.json.JSONException;

import java.util.Optional;
import java.util.UUID;

public interface AccountService {
    void save(Account account) throws DuplicateUserName, JSONException;

    void update (Account account);

    Optional<Account> findById(UUID id);

    Account findByUserName(String userName);

}
