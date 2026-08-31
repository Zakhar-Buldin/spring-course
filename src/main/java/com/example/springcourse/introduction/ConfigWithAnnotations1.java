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

        Процесс внедрения зависимостей при использовании аннотации @Autowired:
            1. Сканирование пакета, поиск классов с аннотацией @Component
            2. При наличии аннотации @Autowired начинается поиск подходящего по типу бина
            Далее ситуация развивается по одному из сценариев:
                1) если находится 1 подходящий бин, то происходит внедрение зависимостей
                2) если подходящих по типу бинов нет или, наоборот, подходящих бинов несколько,
                 то выбрасывается исключение.

        @Autowired может стоять около любого метода, необязательно только у конструктора или сеттера!!!
        И всё равно произойдет внедрение зависимостей.

        Также можно внедрять зависимость по полю, добавляя аннотацию:
            @Autowired
            private Pet pet;

        */

        context.close();
    }
}
