package com.example.account.service.account;

import com.example.account.domain.Account;
import com.example.account.exception.DuplicateUserName;
import com.example.account.repository.AccountRepository;
import com.example.account.service.notification.NotificationService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final NotificationService notificationService;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, NotificationService notificationService) {
        this.accountRepository = accountRepository;
        this.notificationService = notificationService;
    }

    @Override
    public void save(Account account) throws DuplicateUserName, JSONException {
        if (accountRepository.count() != 0) {
            if (accountRepository.existsByUserName(account.getUserName())) {
                throw new DuplicateUserName();
            }
            accountRepository.save(account);
            notificationService.sendSMS(account);
        }

        accountRepository.save(account);
        notificationService.sendSMS(account);

    }

    @Override
    public void update(Account account) {
        accountRepository.save(account);

    }


    @Override
    public Optional<Account> findById(String id) {
        return accountRepository.findById(UUID.fromString(id));
    }

    @Override
    public Account findByUserName(String userName) {
        return accountRepository.findByUserName(userName);
    }

}
