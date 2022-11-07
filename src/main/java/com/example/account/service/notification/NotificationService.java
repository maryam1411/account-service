package com.example.account.service.notification;

import com.example.account.domain.Account;
import com.example.account.enums.NotificationType;
import org.json.JSONException;


public interface NotificationService {

    void sendSMS(Account account) throws JSONException;


}
