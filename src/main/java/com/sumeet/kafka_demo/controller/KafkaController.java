package com.sumeet.kafka_demo.controller;

import com.sumeet.kafka_demo.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class KafkaController {

    @Autowired
    KafkaProducerService producerService;

    @GetMapping("/hello")
    public String hello() {
        return "Kafka app is running";
    }
    @PostMapping("/publish")
    public void publish(@RequestParam String message) {
        producerService.send("demo-topic", message);
        log.info("Message Sent: {}", message);
    }
    @KafkaListener(topics = "demo-topic", groupId = "demo-group")
    public void listen(String message) {
        log.info("Message Received: {}", message);
    }
}
