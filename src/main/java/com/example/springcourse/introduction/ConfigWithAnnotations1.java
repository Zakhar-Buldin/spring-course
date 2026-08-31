package com.example.springcourse.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Cat cat = context.getBean("catBean", Cat.class);
        Person person = context.getBean("personBean", Person.class);
        System.out.println(cat == person.getPet());

        /*
         <context:component-scan base-package="com.example.springcourse.introduction"/> -
         необходимо указать в xml файле.

         "com.example.springcourse.introduction" - пакет, в котором проводится сканирование

        Для указания scope:
            @Component("catBean")
            @Scope("prototype")
            public class Cat implements Pet{...}

        Для создания init и destroy методов:
            @PostConstruct (Аннотация для метода, который будет выполнять функцию init)
            public void init(){...}

            @PreDestroy (Аннотация для метода, который будет выполнять функцию destroy)
            public void destroy(){...}
        */

        context.close();
    }
}
