package com.milton.consumerservice.listener;

import com.milton.commonservice.model.Yak;
import com.milton.consumerservice.service.YakService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MultiTypeKafkaListener {

    private final YakService yakService;
    private final String MESSAGE_TOPIC = "yak-3";
    private final String MESSAGE_GROUP_ID = "milton-yak-group";
    private final String MESSAGE_RETRIES = "3";

    private final String MESSAGE_TOPIC_DEAD_LETTER = "yak-3-dlt";
    private final String MESSAGE_GROUP_ID_DEAD_LETTER = "milton-yak-group-audit";

    public MultiTypeKafkaListener(YakService yakService) {
        this.yakService = yakService;
    }

    @RetryableTopic(backoff = @Backoff(value = 3000L),
            attempts = MESSAGE_RETRIES,
            autoCreateTopics = "false",
            include = {RuntimeException.class})
    @KafkaListener(topics = MESSAGE_TOPIC,
            groupId = MESSAGE_GROUP_ID,
            containerFactory = "manualAckFactory")
    public void handleMessages(ConsumerRecord<String, Yak> consumerRecord,
                               Acknowledgment acknowledgment) {
        try {
            log.info("Topic: {}, Offset: {}, Partition: {}, Message: {}",
                    consumerRecord.topic(), consumerRecord.offset(),
                    consumerRecord.partition(), consumerRecord.value());

            // Store the record
            yakService.addYak(consumerRecord.value());

            // if successful commit the offset
            acknowledgment.acknowledge();
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException("Run time exception thrown", runtimeException);
        }
    }

    @KafkaListener(topics = MESSAGE_TOPIC_DEAD_LETTER,
            groupId = MESSAGE_GROUP_ID_DEAD_LETTER)
    public void auditFailedMessage(ConsumerRecord<String, String> record) {

        log.error("Dead Letter Topic received from topic={}, partition={}, offset={}, key={}, value={}",
                record.topic(), record.partition(), record.offset(), record.key(), record.value());

        // Persist to DB, send alert, or forward to observability pipeline
        //auditService.recordFailure(record);
    }
}