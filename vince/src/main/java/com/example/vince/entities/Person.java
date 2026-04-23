package com.example.vince.entities;

import java.time.LocalDate;

public class Person {

    private String name;
    private int age;

    private String birthPlace;
    private LocalDate birthDate;
    private String gender;

    public Person() {
    }

    public Person(String name, int age, String birthPlace, LocalDate birthDate, String gender) {
        this.name = name;
        this.age = age;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}