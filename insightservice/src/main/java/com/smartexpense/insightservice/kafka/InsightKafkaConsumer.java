package com.smartexpense.insightservice.kafka;

import com.smartexpense.insightservice.entity.Insight;
import com.smartexpense.insightservice.service.InsightService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InsightKafkaConsumer {
    private final InsightService insightService;

    public InsightKafkaConsumer(InsightService insightService) {
        this.insightService = insightService;
    }

    @KafkaListener(topics = "transaction.created", groupId = "insight-service-group")
    public void consumeTransactionEvent(Insight insight) {
        try {
            insightService.saveTransactionInsight(insight);
            System.out.println("Transaction consumed and insight saved: " + insight);
        } catch (Exception e) {
            System.err.println("Error consuming transaction event: " + e.getMessage());
        }
    }
}

