package com.example.account.service.notification;

import com.example.account.enums.NotificationType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEvent {

    private String purpose;
    private String email;
    private NotificationType notificationType;

}
