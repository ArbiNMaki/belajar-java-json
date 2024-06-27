package com.belajar.java.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JsonArrayTest {

    @Test
    void testCreateJsonArray() throws JsonProcessingException {
        List<String> hobbies = List.of("Coding", "Reading", "Traveling");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(hobbies);

        System.out.println(json);
    }
}
