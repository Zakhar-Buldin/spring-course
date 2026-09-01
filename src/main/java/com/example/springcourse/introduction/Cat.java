package com.example.springcourse.introduction;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



public class Cat implements Pet{

    public Cat(){
        System.out.println("Cat bean is created!");
    }

    @Override
    public void say() {
        System.out.println("Meow-meow");
    }


}
