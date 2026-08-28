package com.example.springcourse.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        // !!! - В контексте можно указывать несколько xml файлов

        Dog myDog = context.getBean("myPet", Dog.class);
        Dog yourDog = context.getBean("myPet", Dog.class);


        /*
        Bean Scope определяет жизненный цикл бина и кол-во создаваемых бинов.
        По умолчанию scope - SINGLETON,
        т.е. в Spring контейнере создаётся всего один bean сразу после прочтения конфигурационного файла.
        Этот bean является общим для всех, кто его запросит у Spring.


        <bean id="myPet"
              class="com.example.springcourse.introduction.Dog"
              scope="singleton"> (можно не указывать singleton, т.к. такой scope по умолчанию)
        </bean>

         */

        System.out.println("Переменные сслылаются на один общий объект? - "
                + (myDog == yourDog));

        System.out.println(myDog);
        System.out.println(yourDog);

        System.out.println(myDog.getName());
        System.out.println(yourDog.getName());
    }
}
