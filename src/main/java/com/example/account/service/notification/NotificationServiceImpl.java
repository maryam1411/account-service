package com.example.account.service.notification;


import com.example.account.domain.Account;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private static final Logger LOG = LoggerFactory.getLogger(NotificationService.class);
    private static final String TOPIC = "ACCOUNT_CREATED";
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendSMS(Account account) {
//        Message<String> event = MessageBuilder.withPayload(account.getPhoneNumber()).setHeader(KafkaHeaders.TOPIC, TOPIC)
//                .setHeader(KafkaHeaders.MESSAGE_KEY, "CREATE_ACCOUNT")
//                .build();
//        LOG.info("Sending Data!!" + "  " + account);
//        kafkaTemplate.send(event);
        Properties props = new Properties();
        props.put("key-serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value-serializer", "com.example.account.serializer.AccountSerializer");
        props.put("bootstrap-servers", "localhost:9092");
        try (Producer<String, Account> producer = new KafkaProducer<>(props)) {
            ProducerRecord<String, Account> producerRecord = new ProducerRecord<>(TOPIC, account);
            producer.send(producerRecord);
            System.out.println("Message " + account + " sent !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
