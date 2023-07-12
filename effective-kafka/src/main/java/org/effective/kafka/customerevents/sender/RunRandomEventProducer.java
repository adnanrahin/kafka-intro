package org.effective.kafka.customerevents.sender;

import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Map;

public class RunRandomEventProducer {

    public static void main(String[] args)
            throws InterruptedException, EventSender.SendException {
        final Map<String, Object> config =
                Map.of(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                        "localhost:9092",
                        ProducerConfig.CLIENT_ID_CONFIG,
                        "customer-producer-sample");
        final var topic = "customer.test";
        try (var sender = new DirectSender(config, topic)) {
            final var businessLogic = new ProducerBusinessLogic(sender);
            while (true) {
                businessLogic.generateRandomEvents();
                Thread.sleep(500);
            }
        }
    }
}
