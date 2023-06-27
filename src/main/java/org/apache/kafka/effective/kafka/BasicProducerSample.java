package org.apache.kafka.effective.kafka;

import static java.lang.System.*;

import java.util.*;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.*;


public class BasicProducerSample {

    public static void main(String[] args) throws InterruptedException {

        final String topic = "getting-started";

        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);


        try (Producer<String, String> producer = new KafkaProducer<String, String>(config)) {
            while (true) {
                String key = "myKey";
                String value = new Date().toString();
                out.format("Publishing record with value %s%n",
                        value);
                final Callback callback = (metadata, exception) -> {
                    out.format("Published with metadata: %s, error: %s%n",
                            metadata, exception);
                };
                producer.send(new ProducerRecord<>(topic, key, value),
                        callback);

                Thread.sleep(1000);
            }
        }

    }

}
