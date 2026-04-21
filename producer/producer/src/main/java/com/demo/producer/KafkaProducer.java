package com.demo.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class KafkaProducer {


    private final KafkaTemplate<String , RiderLocation > kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, RiderLocation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;

    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message){
        RiderLocation location = new RiderLocation("rider12", 23.3, 44.66);
        kafkaTemplate.send("my-topic-new", location);
        return "Message sent " + location.getRiderId();
    }

    @GetMapping
    public String get(){
        return "hello";
    }
}
