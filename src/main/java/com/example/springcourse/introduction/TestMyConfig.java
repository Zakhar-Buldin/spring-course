package com.example.springcourse.introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMyConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class); // Создаём и запускаем Spring контейнер
        // При использовании конфигурации с помощью Java кода, Spring контейнер будет представлен классом AnnotationConfigApplicationContext

        /*
            Конфигурация контейнера с помощью Java code. Способ №2 + аннотация @PropertySource:
        Данный способ не использует сканирование пакета и поиск бинов. Здесь бины описываются в конфиг классе.
        Аннотация @Bean перехватывает все обращения к бину и регулирует его создание.
         */
        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();
        System.out.println(person.getSurname());
        context.close();
    }
}
