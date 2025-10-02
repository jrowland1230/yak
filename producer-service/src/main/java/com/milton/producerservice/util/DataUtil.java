package com.milton.producerservice.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class DataUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();;

    public DataUtil() {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true); // Pretty-print JSON
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false); // Use ISO-8601 for dates
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); // Exclude null fields
    }

    public static <T> String  getVehicleAsString(T value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException jsonProcessingException) {
            log.error(jsonProcessingException.getMessage(), jsonProcessingException);
            throw new RuntimeException(jsonProcessingException);
        }
    }

    public static String getUniqueIdentifier() {
        return UUID.randomUUID().toString();
    }
}
