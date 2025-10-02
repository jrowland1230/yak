package com.milton.producerserver.messaging;

public interface KafkaProducer<T> {
    void sendMessageWithRetry(T message);
}
