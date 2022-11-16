package com.example.account.notificationservice;

import com.example.account.domain.Account;
import com.example.account.exception.DuplicateUserName;
import com.example.account.service.notification.NotificationService;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NotificationServiceTest {


    private NotificationService notificationService;


    @BeforeEach
    public void setup() {
        this.notificationService = Mockito.mock(NotificationService.class);
    }


    @Test
    void sendSMSWhenAccountCreated() throws DuplicateUserName, JSONException {
        Account account = Account.builder()
                .firstName("maryam")
                .lastName("tanveer")
                .email("maryam@gmail.com")
                .password("1234")
                .phoneNumber("3333")
                .userName("maryam")
                .build();
        notificationService.sendSMS(account);
        // can mock data and then verify the sms sent or not

    }


}
