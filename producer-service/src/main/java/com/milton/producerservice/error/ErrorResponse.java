package com.milton.producerservice.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ErrorResponse {

    @Getter
    public String status;
    @Getter
    public Integer code;
    @Getter
    public String serviceCode;
    @Getter
    public String serviceDescription;
    @Getter
    public String message;
    @Getter
    public String timestamp;

    public ErrorResponse(HttpStatus status, String code, String description,
                         String message, String timestamp) {
        super();
        this.status = status.getReasonPhrase();
        this.code = status.value();
        this.serviceCode = code;
        this.serviceDescription = description;
        this.message = message;
        this.timestamp = timestamp;
    }
}
