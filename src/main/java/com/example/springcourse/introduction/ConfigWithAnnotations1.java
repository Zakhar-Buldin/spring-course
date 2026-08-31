package com.example.springcourse.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        Person person = context.getBean("personBean", Person.class);
        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        /*
         <context:component-scan base-package="com.example.springcourse.introduction"/> -
         необходимо указать в xml файле.

         "com.example.springcourse.introduction" - пакет, в котором проводится сканирование

        Для внедрения строк и других значений можно использовать аннотацию @Value("...").
        В этом случае в сеттеры НЕ БУДУТ передаваться значения, как это было при конфигурации
        с помощью xml файла (<property name="age" value="21"/>)

        Лучше указывать не конкретные значения у каждого поля, а переменные из properties файла:

        @Value("${person.surname}")
        private String surname;

        Не забываем про: <context:property-placeholder location="classpath:myApp.properties"/>!
        */

        context.close();
    }
}
