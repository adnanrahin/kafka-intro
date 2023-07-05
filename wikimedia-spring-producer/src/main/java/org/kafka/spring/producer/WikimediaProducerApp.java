package org.kafka.spring.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WikimediaProducerApp {

    public static void main(String[] args) {
        SpringApplication.run(WikimediaProducerApp.class, args);
    }

}
