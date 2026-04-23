package com.example.vince.services;

import com.example.vince.entities.Person;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private List<Person> persons = new ArrayList<>();

    public List<Person> getAllPersons() {
        return persons;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public List<Person> findByName(String name) {
        return persons.stream()
                .filter(p -> p.getName() != null &&
                        p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Person> findByBirthPlace(String birthPlace) {
        return persons.stream()
                .filter(p -> p.getBirthPlace() != null &&
                        p.getBirthPlace().toLowerCase().contains(birthPlace.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Person> findByGender(String gender) {
        return persons.stream()
                .filter(p -> p.getGender() != null &&
                        p.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }

    public List<Person> findByBirthDate(LocalDate date) {
        return persons.stream()
                .filter(p -> date.equals(p.getBirthDate()))
                .collect(Collectors.toList());
    }
}