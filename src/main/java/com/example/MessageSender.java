package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageSender {

    @Autowired
    private TestKafkaListener listener;

    @GetMapping("/test")
    public void test() {
        listener.sendMessage();
    }
}
