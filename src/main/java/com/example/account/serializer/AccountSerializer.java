package com.example.account.serializer;

import com.example.account.domain.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class AccountSerializer implements Serializer<Account> {
    @Override
    public byte[] serialize(String s, Account account) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(account).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }


}




