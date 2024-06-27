package com.belajar.java.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JacksonAnnotationTest {

    @Test
    void testAnnotation() throws JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(dateFormat);

        Person person = new Person();
        person.setId("1");
        person.setName("Arbi");
        person.setFullName("Arbi Dwi Wijaya");
        person.setPassword("Himitsu");
        person.setCreatedAt(new Date());
        person.setUpdateAt(new Date());

        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }
}
