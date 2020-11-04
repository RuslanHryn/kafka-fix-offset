package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestKafkaListener {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() {
        kafkaTemplate.executeInTransaction(operations -> {
            operations.send("TestTopic", "hi");
            return true;
        });
    }

    @KafkaListener(topics = "TestTopic")
    public void receiveMessage(String message) {
        log.info(message);
    }
}
