package com.belajar.java.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DeserializationFeatureTest {

    @Test
    void testDeserializationFeature() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        String json = """
                {"id":"1","name":"Arbi","age":27,"hobbies":"Coding"}
                """;
        Person person = objectMapper.readValue(json, Person.class);

        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Arbi", person.getName());
        Assertions.assertEquals(List.of("Coding"), person.getHobbies());
    }
}
