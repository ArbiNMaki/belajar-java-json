package com.belajar.java.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SerializationFeatureTest {

    @Test
    void testSerializationFeature() throws JsonProcessingException {
       Person person = new Person();
       person.setId("1");
       person.setName("Arbi");
       person.setHobbies(List.of("Coding", "Gaming"));

       Address address = new Address();
       address.setStreet("Jalan Peltu Sujono");
       address.setCountry("Malang");
       address.setCountry("Indonesia");
       person.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true);
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }
}
