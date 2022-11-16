package com.example.account.service.notification;


import com.example.account.domain.Account;
import com.example.account.enums.NotificationType;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private static final Logger LOG = LoggerFactory.getLogger(NotificationService.class);
    private static final String TOPIC = "ACCOUNT_CREATED";
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendSMS(Account account) {
        Message<String> event = MessageBuilder.withPayload(account.getPhoneNumber()).setHeader(KafkaHeaders.TOPIC, TOPIC)
                .setHeader(KafkaHeaders.MESSAGE_KEY, "CREATE_ACCOUNT")
                .build();
        LOG.info("Sending Data!!" + "  " + account.getPhoneNumber());
        kafkaTemplate.send(event);
    }


}
