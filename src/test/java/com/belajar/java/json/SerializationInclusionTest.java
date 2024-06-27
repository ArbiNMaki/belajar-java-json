package com.belajar.java.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class SerializationInclusionTest {

    @Test
    void testSerializationInclusion() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Person person = new Person();
        person.setId("1");
        person.setName("Arbi");

        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }
}
