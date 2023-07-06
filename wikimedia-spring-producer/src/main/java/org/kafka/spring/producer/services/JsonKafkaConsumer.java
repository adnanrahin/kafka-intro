package org.kafka.spring.producer.services;

import org.kafka.spring.producer.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger((JsonKafkaConsumer.class));

    @KafkaListener(topics = "spring-json-topic", groupId = "myGroup")
    public void consumerJson(User user) {

        log.info("Json Message Received:" + String.valueOf(user));

    }

}
