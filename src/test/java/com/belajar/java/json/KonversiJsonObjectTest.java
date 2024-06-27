package com.belajar.java.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class KonversiJsonObjectTest {

    @Test
    void testCreateObjectFromJson() throws JsonProcessingException {
        String json = """
                  {
                  "address": {
                    "street": "Jalan Peltu Sujono",
                    "city": "Malang",
                    "country": "Indonesia"
                  },
                  "hobbies": [
                    "Coding",
                    "Gaming"
                  ],
                  "id": "1",
                  "name": "Arbi"
                }
                """;
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);

        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Arbi", person.getName());
        Assertions.assertEquals("Jalan Peltu Sujono", person.getAddress().getStreet());
        Assertions.assertEquals("Malang", person.getAddress().getCity());
        Assertions.assertEquals("Indonesia", person.getAddress().getCountry());
        Assertions.assertEquals(List.of("Coding", "Gaming"), person.getHobbies());
    }
}
