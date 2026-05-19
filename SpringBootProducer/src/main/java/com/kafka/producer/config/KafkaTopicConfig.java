package com.kafka.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic(){

        Map<String, String> topicConfigurations = new HashMap<>();
        topicConfigurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // delete (Borra mensajes a tiempo configurado), Compact (Mantiene el mensaje mas actual)
        topicConfigurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // Tiempo de retencion de mensajes en milisegundos por defecto viene en -1 -> nunca
        topicConfigurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // Tamaño maximo de segmento en bytes por defecto viene en 1gb
        topicConfigurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000000"); // Tamaño maximo de cada mensaje por defecto vienen en 1 mb

        return TopicBuilder.name("mensajeria-Topic")
                .partitions(2)
                .replicas(1)
                .configs(topicConfigurations)
                .build();
    }
}
