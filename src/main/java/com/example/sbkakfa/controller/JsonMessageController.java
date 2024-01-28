package com.example.sbkakfa.controller;


import com.example.sbkakfa.User;
import com.example.sbkakfa.kafka.KafkaJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/kafka")
public class JsonMessageController {

    private KafkaJsonProducer kafkaJsonProducer;

    public JsonMessageController(KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaJsonProducer.sendMessage(user);
        return ResponseEntity.ok("JSON Sent to kafka topic ");
    }
}
