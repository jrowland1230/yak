package com.milton.commonservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String username;
    private String displayName;
    private String profileImageUrl;
    private String createdDate;
    private String updatedDate;
}
