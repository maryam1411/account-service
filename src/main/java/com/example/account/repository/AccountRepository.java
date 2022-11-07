package com.example.account.repository;

import com.example.account.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface AccountRepository extends MongoRepository<Account, UUID> {
    @Transactional
    @Query("select c from account c where c.userName =?1")
    Account findByUserName(String userName);

    Boolean existsByUserName(String username);
}
