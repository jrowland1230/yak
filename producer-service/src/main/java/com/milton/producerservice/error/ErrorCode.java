package com.milton.producerservice.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ErrorCode {

    MILTON_SERVICE_NOT_FOUND_ERROR("MiltonService-1000", "Error Message"),
    MILTON_SERVICE_BAD_REQUEST_ERROR("MiltonService-1001", "Error Message");

    @Getter
    private final String errCode;

    @Getter
    private final String errorDescription;
}
