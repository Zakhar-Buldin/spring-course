package com.example.springcourse.introduction;

import org.springframework.stereotype.Component;

@Component("dogBean") // В двойных кавычках указывается id для бина (Конфигурация при помощи аннотаций)
public class Dog implements Pet {

    public Dog(){
        System.out.println("Dog bean is created!");
    }

    @Override
    public void say(){
        System.out.println("Bow-wow");
    }



}
