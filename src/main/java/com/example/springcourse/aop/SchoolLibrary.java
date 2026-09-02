package com.example.springcourse.aop;

import org.springframework.stereotype.Component;

@Component // id бина = schoolLibrary
public class SchoolLibrary extends AbstractLibrary{

    @Override
    public void getBook() {
        System.out.println("Мы берём книгу из SchoolLibrary");
    }

    public void returnMagazine(){
        System.out.println("Мы возвращаем журнал в SchoolLibrary");
    }

}
