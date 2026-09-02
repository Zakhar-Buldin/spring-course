package com.example.springcourse.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // id бина = "book"
public class Book {

    @Value("Граф Монте-Кристо")
    private String name;

    public String getName(){
        return name;
    }
}
