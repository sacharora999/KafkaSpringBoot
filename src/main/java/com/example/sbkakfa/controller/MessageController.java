package com.example.sbkakfa.controller;


import com.example.sbkakfa.kafka.KakfaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    private KakfaProducer kakfaProducera;

    public MessageController(KakfaProducer kakfaProducera) {
        this.kakfaProducera = kakfaProducera;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kakfaProducera.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
