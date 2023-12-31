package org.apache.kafka.schema.avro;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.kafka.clients.consumer.*;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;


/**
 * Consumer for Avro-Encoded Kafka Messages.
 * 
 * @author Affan Hasan
 */
public class KafkaAvroMessageConsumer {

	private static final String TOPIC_NAME = "customer-topic";
	private static final String KAFKA_SERVER_ADDRESS = "localhost:9092";
	private static final String SCHEMA_REGISTRY_SERVER_URL = "http://localhost:8081";
	private static final String CONSUMER_GROUP_ID = "customer-message-consumer-group-2222";

    public static void main(final String[] args) {
    	// Kafka Consumer Configurations
        final Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER_ADDRESS);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, CONSUMER_GROUP_ID);
        properties.put("schema.registry.url", SCHEMA_REGISTRY_SERVER_URL);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

        try(final Consumer<String, Customer> consumer = new KafkaConsumer<>(properties)){
        	consumer.subscribe(Collections.singleton(TOPIC_NAME));
        	while (true) {
        		final ConsumerRecords<String, Customer> records = consumer.poll(Duration.ofMillis(100));
        		
        		for (final ConsumerRecord<String, Customer> record : records) {
        			System.out.printf("Message Key:[ %s ] Message Payload: [ %s ]%n", record.key(), record.value());
        		}
        		consumer.commitAsync();
        	}
        }
    }

}
