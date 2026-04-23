package com.example.vince.services;

import com.example.vince.entities.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    private PersonService personService;

    @BeforeEach
    public void setup() {
        personService = new PersonService();

        personService.addPerson(new Person(
                "Alice", 25, "Paris",
                LocalDate.of(2000, 5, 12),
                "F"
        ));

        personService.addPerson(new Person(
                "Bob", 30, "Lyon",
                LocalDate.of(1995, 3, 10),
                "M"
        ));
    }

    @Test
    public void testFindByName() {
        List<Person> result = personService.findByName("alice");
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
    }

    @Test
    public void testFindByGender() {
        List<Person> result = personService.findByGender("M");
        assertEquals(1, result.size());
        assertEquals("Bob", result.get(0).getName());
    }

    @Test
    public void testFindByBirthPlace() {
        List<Person> result = personService.findByBirthPlace("paris");
        assertEquals(1, result.size());
    }

    @Test
    public void testFindByBirthDate() {
        List<Person> result = personService.findByBirthDate(
                LocalDate.of(2000, 5, 12)
        );
        assertEquals(1, result.size());
    }
}