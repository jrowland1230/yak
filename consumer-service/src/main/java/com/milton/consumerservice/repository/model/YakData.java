package com.milton.consumerservice.repository.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "yaks")
public class YakData {
    public YakData() { }
    @Id
    private String id;
    private String status;
    @NotNull
    private String content;
    private String userId;
    private String createdDate;
    private String updatedDate;
    private List<String> hashTags;
    private List<String> userMentionedIds;
    private int likes;
    private int reYaks;
    private int replies;
    private String parentYakId;
    private List<String> childYakIds;


}
