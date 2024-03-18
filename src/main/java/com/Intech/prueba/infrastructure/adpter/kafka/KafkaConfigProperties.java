package com.Intech.prueba.infrastructure.adpter.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/**
 * This class is responsible for reading the Kafka configuration properties from the application.properties file.
 * It uses the Spring Framework's @ConfigurationProperties annotation to map the properties to the fields of this class.
 */
@Configuration
@ConfigurationProperties(prefix = "kafka")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class KafkaConfigProperties {
    private String acks = "0";
    private String compressionType = "snappy";
    private int retries = 3;
    private int deliveryTimeoutMs = 120000;
    private int maxRequestSize = 1068576;
    private int requestTimeoutMs = 30000;
    //private String orderMongoProjectionGroupId = "projection-group";
    private String enableAutoCommit = "false";
    private int consumerParallelism = 16;
    private int eventsTopicPartitions = 6;
    private int eventsTopicReplicationFactor = 1;
}