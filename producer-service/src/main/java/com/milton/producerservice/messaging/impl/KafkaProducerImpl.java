package com.milton.producerservice.messaging.impl;

import com.milton.producerserver.messaging.KafkaProducer;
import com.milton.producerservice.util.DataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class KafkaProducerImpl<T> implements KafkaProducer<T> {

    private final KafkaTemplate<String, T> kafkaTemplate;
    private final String MESSAGE_TOPIC = "yak-3";

    public KafkaProducerImpl(KafkaTemplate<String, T> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessageWithRetry(T message) {

        String key = DataUtil.getUniqueIdentifier();
        log.info("Sending message with topic {}, key {}, message {}", MESSAGE_TOPIC, key, message);

        CompletableFuture<SendResult<String, T>> future = kafkaTemplate.send(MESSAGE_TOPIC, key, message);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message with topic {}, key {}, offset {}, message {}", MESSAGE_TOPIC,
                        key, result.getRecordMetadata().offset(), result.getProducerRecord().value());
            } else {
                log.error("Unable to send message with topic {}, key {}, message {}, error {}",
                        MESSAGE_TOPIC, key, result.getProducerRecord().value(), ex.getMessage());
            }
        });
    }
}
