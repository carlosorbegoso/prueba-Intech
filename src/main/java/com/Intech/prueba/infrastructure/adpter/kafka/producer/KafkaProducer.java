package com.Intech.prueba.infrastructure.adpter.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
@Slf4j
@EnableKafka
public class KafkaProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        log.info(String.format("Sending message to topic: %s", message));
        kafkaTemplate.send("topic-reto", message);
    }
}
