package com.example.springcourse.aop;
import org.springframework.stereotype.Component;

@Component // id бина = uniLibrary
public class UniLibrary {


    public String returnBook(){
        int a = 10 / 0; // Некорректная операция (создание исключения)
        System.out.println("returnBook: Мы возвращаем книгу в UniLibrary");
        return "Война и Мир";
    }

}
