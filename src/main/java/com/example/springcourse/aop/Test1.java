package com.example.springcourse.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class); // Создание и запуск Spring контейнера

        UniLibrary unilibrary = context.getBean("uniLibrary", UniLibrary.class);
        unilibrary.getBook();
        unilibrary.returnBook();
        unilibrary.getMagazine("Правда", 3);

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();
        schoolLibrary.returnMagazine();
        schoolLibrary.getMagazine("New-York Times");

        Book book = context.getBean("book", Book.class);
        unilibrary.getCustomBook(book);
    }
}
