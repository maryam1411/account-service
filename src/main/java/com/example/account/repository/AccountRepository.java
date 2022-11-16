package com.example.account.repository;

import com.example.account.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends MongoRepository<Account, UUID> {
    Account findByUserName(String userName);

    Boolean existsByUserName(String username);


}
