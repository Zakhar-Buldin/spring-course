package com.example.springcourse.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        /*

         <context:component-scan base-package="com.example.springcourse.introduction"/> -
         необходимо указать в xml файле.

         "com.example.springcourse.introduction" - пакет, в котором проводится сканирование

        Если при использовании @Autowired подходящих по типу бинов больше одного,
        то выбрасывается исключение. Предотвратить это можно конкретно указав,
        какой бин должен быть внедрён. Для этого используют аннотацию @Qualifier.

        @Qualifier можно указывать у сеттера, поля или конструктора (у последнего не типичный синтаксис)
        */

        context.close();
    }
}
