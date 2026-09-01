package com.example.springcourse.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class); // Создание и запуск Spring контейнера

        Library library = context.getBean("libraryBean", Library.class);
        library.getBook();
    }
}
