package com.example.springcourse.introduction;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("catBean") // В двойных кавычках указывается id для бина (Конфигурация при помощи аннотаций)
@Scope("prototype") // Аннотация для указания scope бина
public class Cat implements Pet{

    public Cat(){
        System.out.println("Cat bean is created!");
    }

    @Override
    public void say() {
        System.out.println("Meow-meow");
    }

    @PostConstruct // Аннотация для метода, который будет выполнять функцию init
    public void init(){
        System.out.println("Class Cat: init method");
    }

    @PreDestroy // Аннотация для метода, который будет выполнять функцию destroy
    public void destroy(){
        System.out.println("Class Cat: destroy method");
    }
}
