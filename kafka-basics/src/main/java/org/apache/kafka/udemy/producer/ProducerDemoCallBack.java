package org.apache.kafka.udemy.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemoCallBack {

    private static final Logger log = LoggerFactory.getLogger(ProducerDemoCallBack.class.getSimpleName());

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());
        properties.put("batch.size", "400");


        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 30; i++) {
                ProducerRecord<String, String> producerRecord =
                        new ProducerRecord<>("demo_java", "hello-world" + i);

                producer.send(producerRecord, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                        if (e == null) {
                            log.info("Received New Metadata \n" +
                                    "Topic:" + recordMetadata.topic() + " \n" +
                                    "Partition:" + recordMetadata.partition() + " \n" +
                                    "Offset:" + recordMetadata.offset() + " \n" +
                                    "Time Stamp:" + recordMetadata.timestamp() + " \n");
                        } else {
                            log.error("Error While Producing");
                        }

                    }
                });
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        producer.flush();

        producer.close();

    }

}
