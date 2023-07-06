package org.kafka.spring.producer.services;


import org.kafka.spring.producer.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger((JsonKafkaProducer.class));

    private KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void senMessage(User userData) {

        log.info(String.format("Message Sent -> %s", userData.toString()));

        Message<User> message = MessageBuilder
                .withPayload(userData)
                .setHeader(KafkaHeaders.TOPIC, "spring-json-topic")
                .build();

        kafkaTemplate.send(message);

        log.info("Message Sent");

    }


}
