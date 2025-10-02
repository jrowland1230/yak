package com.milton.consumerservice.repository;

import com.milton.consumerservice.repository.model.YakData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface YakRepository extends MongoRepository<YakData, String> {
    List<YakData> findByUserId(String userId);
    List<YakData> findByStatus(String status);
}