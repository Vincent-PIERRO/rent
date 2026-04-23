package com.example.vince.entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testGettersAndSetters() {

        Person person = new Person();

        person.setName("Alice");
        person.setAge(25);
        person.setBirthPlace("Paris");
        person.setBirthDate(LocalDate.of(2000, 5, 12));
        person.setGender("F");

        assertEquals("Alice", person.getName());
        assertEquals(25, person.getAge());
        assertEquals("Paris", person.getBirthPlace());
        assertEquals(LocalDate.of(2000, 5, 12), person.getBirthDate());
        assertEquals("F", person.getGender());
    }
}