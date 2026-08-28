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

        PROTOTYPE:
            Такой бин создаётся только после каждого обращения к Spring контейнеру с помощью метода
            getBean!!! Для каждого обращения создаётся новый бин.


        <bean id="myPet"
              class="com.example.springcourse.introduction.Dog"
              scope="prototype">
        </bean>

         */

        System.out.println("Переменные сслылаются на один общий объект? - "
                + (myDog == yourDog));

        System.out.println(myDog);
        System.out.println(yourDog);

    }
}
