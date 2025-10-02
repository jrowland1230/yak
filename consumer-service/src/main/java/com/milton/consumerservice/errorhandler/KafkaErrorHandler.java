package com.milton.consumerservice.errorhandler;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Slf4j
@Configuration
public class KafkaErrorHandler {

    @Bean
    public DefaultErrorHandler errorHandler(KafkaTemplate<String, String> kafkaTemplate) {
        DeadLetterPublishingRecoverer recoverer = new DeadLetterPublishingRecoverer(
                kafkaTemplate,
                (record, ex) -> new TopicPartition(record.topic() + "-dlt",0)
        );

        FixedBackOff backOff = new FixedBackOff(1000L, 3); // Retry 3 times with 1s delay
        DefaultErrorHandler handler = new DefaultErrorHandler(recoverer, backOff);
        handler.setSeekAfterError(false);
        handler.setCommitRecovered(true); // Commit offset after sending to DLT

        return handler;
    }
}
