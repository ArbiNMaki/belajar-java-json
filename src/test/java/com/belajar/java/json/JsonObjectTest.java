package com.belajar.java.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonObjectTest {

    @Test
    void testCreateJSON() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "firstName", "Arbi",
                "middleName", "Dwi",
                "lastName", "Wijaya",
                "age", 27,
                "married", false,
                "address", Map.of(
                        "street", "Jalan Peltu Sujono",
                        "city", "Malang",
                        "country", "Indonesia"
                )
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }
}
