package com.example.springcourse.introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMyConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class); // Создаём и запускаем Spring контейнер
        // При использовании конфигурации с помощью Java кода, Spring контейнер будет представлен классом AnnotationConfigApplicationContext


        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        context.close();
    }
}
