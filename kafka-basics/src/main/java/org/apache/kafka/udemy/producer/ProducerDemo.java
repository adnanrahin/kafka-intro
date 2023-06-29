package org.apache.kafka.udemy.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemo {

    private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());


        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>("demo_java", "hello-world");

        producer.send(producerRecord);

        producer.flush();

        producer.close();

    }

}
