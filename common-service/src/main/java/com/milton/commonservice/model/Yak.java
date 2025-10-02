package com.milton.commonservice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Yak {
    private String id;
    private String content;
    private String userId;
    private String createdDate;
    private String updatedDate;
    private List<String> hashTags;
    private List<String> userMentionedIds;
    private String parentYakId;
    private List<String> childYakIds;
    private int likes;
    private int reYaks;
    private int replies;
}
