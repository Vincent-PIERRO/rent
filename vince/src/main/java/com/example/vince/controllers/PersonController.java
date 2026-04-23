package com.example.vince.controllers;

import com.example.vince.entities.Person;
import com.example.vince.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersons() {
        return personService.getAllPersons();
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping("/search/name")
    public List<Person> searchByName(@RequestParam String name) {
        return personService.findByName(name);
    }

    @GetMapping("/search/birthplace")
    public List<Person> searchByBirthPlace(@RequestParam String birthPlace) {
        return personService.findByBirthPlace(birthPlace);
    }

    @GetMapping("/search/gender")
    public List<Person> searchByGender(@RequestParam String gender) {
        return personService.findByGender(gender);
    }

    @GetMapping("/search/birthdate")
    public List<Person> searchByBirthDate(@RequestParam String date) {
        LocalDate birthDate = LocalDate.parse(date);
        return personService.findByBirthDate(birthDate);
    }
}