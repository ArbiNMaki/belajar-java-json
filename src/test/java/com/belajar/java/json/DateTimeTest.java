package com.belajar.java.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeTest {

    @Test
    void testDateTimeMilis() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = new Person();
        person.setId("1");
        person.setName("Arbi");
        person.setCreatedAt(new Date());
        person.setUpdateAt(new Date());

        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void testDateTimeFormatter() throws JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(dateFormat);

        Person person = new Person();
        person.setId("1");
        person.setName("Arbi");
        person.setCreatedAt(new Date());
        person.setUpdateAt(new Date());

        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }
}
