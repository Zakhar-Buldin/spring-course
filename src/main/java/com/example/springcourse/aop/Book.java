package com.example.springcourse.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // id бина = "book"
public class Book {

    @Value("Граф Монте-Кристо")
    private String name;
    @Value("Александр Дюма")
    private String author;
    @Value("1846")
    private int yearOfPublication;

    public String getName(){
        return name;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }
}
