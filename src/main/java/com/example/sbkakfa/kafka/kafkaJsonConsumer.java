package com.example.sbkakfa.kafka;

import com.example.sbkakfa.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(kafkaJsonConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "myGroup")
    public void consume(User user){
        LOGGER.info(String.format("Message received -> %s ", user.toString()));
    }


}
