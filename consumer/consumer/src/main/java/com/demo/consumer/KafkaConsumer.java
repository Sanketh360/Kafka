package com.demo.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic" , groupId = "my-new_group")
    public void listen(String message){
        System.out.println("Recieved message 1 " + message);
    }

    @KafkaListener(topics = "my-topic" , groupId = "my-new_group_1")
    public void listen1(String message){
        System.out.println("Recieved message 2 " + message);
    }
}
