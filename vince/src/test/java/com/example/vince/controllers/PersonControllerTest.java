package com.example.vince.controllers;

import com.example.vince.entities.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddPerson() throws Exception {
        Person person = new Person(
                "Charlie",
                28,
                "Marseille",
                LocalDate.of(1997, 2, 15),
                "M"
        );

        mockMvc.perform(post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(person)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPersons() throws Exception {
        mockMvc.perform(get("/persons"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSearchByName() throws Exception {
        mockMvc.perform(get("/persons/search/name")
                        .param("name", "alice"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSearchByGender() throws Exception {
        mockMvc.perform(get("/persons/search/gender")
                        .param("gender", "F"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSearchByBirthPlace() throws Exception {
        mockMvc.perform(get("/persons/search/birthplace")
                        .param("birthPlace", "paris"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSearchByBirthDate() throws Exception {
        mockMvc.perform(get("/persons/search/birthdate")
                        .param("date", "2000-05-12"))
                .andExpect(status().isOk());
    }
}