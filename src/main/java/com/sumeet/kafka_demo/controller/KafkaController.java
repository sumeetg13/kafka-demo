package com.sumeet.kafka_demo.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @GetMapping("/hello")
    public String hello() {
        return "Kafka app is running";
    }
    @KafkaListener(topics = "demo-topic", groupId = "demo-group")
    public void listen(String message) {
        System.out.println("Received: " + message);
    }
}
