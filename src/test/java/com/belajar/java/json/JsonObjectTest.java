package com.belajar.java.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
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

    @Test
    void testReadJSON() throws JsonProcessingException {
        String json = """
                 {
                 "address": {
                                         "street": "Jalan Peltu Sujono",
                                         "country": "Indonesia",
                                         "city": "Malang"
                                       },
                                       "age": 27,
                                       "firstName": "Arbi",
                                       "lastName": "Wijaya",
                                       "married": false,
                                       "middleName": "Dwi"
                                       }
                }
                """;
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> person = objectMapper
                .readValue(json, new TypeReference<Map<String, Object>>() {
                });

        Assertions.assertEquals("Arbi", person.get("firstName"));
        Assertions.assertEquals("Dwi", person.get("middleName"));

        Map<String, Object> address = (Map<String, Object>) person.get("address");
        Assertions.assertEquals("Malang", address.get("city"));
    }
}
