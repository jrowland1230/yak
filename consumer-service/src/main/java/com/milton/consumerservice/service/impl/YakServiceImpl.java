package com.milton.consumerservice.service.impl;

import com.milton.commonservice.model.Yak;
import com.milton.consumerservice.repository.YakRepository;
import com.milton.consumerservice.repository.model.YakData;
import com.milton.consumerservice.service.YakService;
import com.mongodb.MongoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Slf4j
@Service
public class YakServiceImpl implements YakService {

    private final YakRepository yakRepository;

    public YakServiceImpl(YakRepository yakRepository) {
        this.yakRepository = yakRepository;
    }

    @Override
    public void addYak(Yak yak) {
        try {
            YakData yakData = new YakData();
            yakData.setStatus("DELIVERED");
            yakData.setContent(yak.getContent());
            yakData.setUserId(yak.getUserId());
            yakData.setCreatedDate(ZonedDateTime.now(ZoneOffset.UTC).toString());
            yakData.setUpdatedDate(ZonedDateTime.now(ZoneOffset.UTC).toString());
            yakData.setChildYakIds(yak.getChildYakIds());
            yakData.setParentYakId(yak.getParentYakId());
            yakData.setLikes(yak.getLikes());
            yakData.setReplies(yak.getReplies());
            yakData.setHashTags(yak.getHashTags());
            yakData.setReYaks(yak.getReYaks());
            yakData.setUserMentionedIds(yak.getUserMentionedIds());

            // Save or update yak data
            YakData yakDataResult = yakRepository.save(yakData);

            if (yakDataResult.getId() == null) {
                throw new RuntimeException();
            }

            log.info("Yak saved successfully with id: {}", yakDataResult.getId());
        } catch (MongoException mongoException) {
            throw new RuntimeException("Error saving yak data", mongoException);
        }
    }
}
