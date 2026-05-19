package com.kafka.consumer.listeners;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = "mensajeria-Topic", groupId = "mensajeria-Group")
    public void listener(String message){
        LOGGER.info("Mensaje recibido: "+ message);
    }
}
