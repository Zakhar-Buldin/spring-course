package com.example.springcourse.introduction;
import org.springframework.stereotype.Component;


@Component("catBean") // В двойных кавычках указывается id для бина (Конфигурация при помощи аннотаций)
public class Cat implements Pet{

    public Cat(){
        System.out.println("Cat bean is created!");
    }

    @Override
    public void say() {
        System.out.println("Mew-mew");
    }

    public void init(){
        System.out.println("Class Cat: init method");
    }

    public void destroy(){
        System.out.println("Class Cat: destroy method");
    }
}
