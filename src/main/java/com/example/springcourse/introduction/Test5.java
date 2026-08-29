package com.example.springcourse.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        Dog myDog = context.getBean("myPet", Dog.class);
        myDog.say();

        /*
        Методы init и destroy:
            init - вызывается сразу после создания бина Spring контейнером
            (если scope = singleton, то вызывается единожды,
            если prototype - то вызывается после каждого обращения к контейнеру методом getBean)
            destroy - если scope = singleton, то вызывается перед завершением работы контейнера
            (перед закрытием контекста), если prototype - не вызывается вовсе!!!

        <bean id="myPet"
              class="com.example.springcourse.introduction.Dog"
              init-method="init"
              destroy-method="destroy">
        </bean>

        В кавычках указывается название метода, который мы создали в классе Dog.
        Название этих методов в классе может быть любым!
        Главное - корректно передать имена методов,
        которые будут выполнять функцию init и destroy, в xml файл.
         */

        context.close();
    }
}
