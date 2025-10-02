package com.milton.producerservice.exception;

import com.milton.producerservice.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

public class MiltonResourceException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public final HttpStatus httpStatus;
    public final ErrorCode code;
    public final String message;
    @Getter
    private final Throwable exception;

    public MiltonResourceException(HttpStatus httpStatus, ErrorCode code, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.exception = null;
    }

    public MiltonResourceException(HttpStatus httpStatus, ErrorCode code, String message, Throwable exception) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
        this.exception = exception;
    }
}
