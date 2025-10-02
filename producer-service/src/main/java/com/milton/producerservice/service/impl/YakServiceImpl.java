package com.milton.producerservice.service.impl;

import com.milton.commonservice.model.Yak;
import com.milton.producerserver.messaging.KafkaProducer;
import com.milton.producerservice.service.YakService;
import com.milton.producerservice.util.DataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class YakServiceImpl implements YakService {

    private final KafkaProducer<Yak> kafkaProducer;

    public YakServiceImpl(KafkaProducer<Yak> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public Yak addYak(Yak yak) {
        log.info("Publish Yak to Kafka");

        yak.setId(DataUtil.getUniqueIdentifier());
        kafkaProducer.sendMessageWithRetry(yak);
        return yak;
    }
}