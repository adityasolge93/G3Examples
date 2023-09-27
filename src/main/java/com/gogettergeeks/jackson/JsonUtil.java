package com.gogettergeeks.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A generic utility class for converting Java Object to JSON and vice-versa. This class makes
 * use of Jackson library to accomplish the same.
 *
 * @param <T>
 */
public class JsonUtil<T> {
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Converts Java Object to JSON string.
     *
     * @param object
     * @return
     * @throws JsonProcessingException
     */
    public String toJson(T object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    /**
     * Converts JSON String to Java Object.
     *
     * @param json
     * @param type
     * @return
     * @throws JsonProcessingException
     */
    public T fromJson(String json, Class<T> type) throws JsonProcessingException {
        return objectMapper.readValue(json, type);
    }
}
