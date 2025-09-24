package com.smartexpense.ledgerservice.kafka;

import com.smartexpense.ledgerservice.event.TransactionEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionProducer {

    private static final String TOPIC = "transaction.created";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public TransactionProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTransactionEvent(Object transactionEvent) {
        kafkaTemplate.send(TOPIC, transactionEvent);
        System.out.println("📢 Transaction event published to Kafka: " + transactionEvent);
    }
}
