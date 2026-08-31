package com.example.springcourse.introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("personBean") // В двойных кавычках указывается id бина
public class Person {
    private Pet pet;
    private String surname;
    private int age;

    @Autowired // Внедрение зависимости через аннотацию у конструктора
    public Person(Pet pet){
        this.pet = pet;
        System.out.println("Person bean is created!");
    }

    public void callYourPet(){
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }
    public void setPet(Pet pet){
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }
}
