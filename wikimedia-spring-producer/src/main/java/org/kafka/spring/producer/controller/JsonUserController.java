package org.kafka.spring.producer.controller;


import org.kafka.spring.producer.models.User;
import org.kafka.spring.producer.services.JsonKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonUserController {

    private final JsonKafkaProducer jsonKafkaProducer;

    @Autowired
    public JsonUserController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/json_publish")
    public ResponseEntity<String> userMessage(@RequestBody User user) {

        jsonKafkaProducer.senMessage(user);

        return ResponseEntity.ok("Json Message Sent");
    }

}
