package com.example.springcourse.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        /*
        Метод init и destroy:
            Spring scope = prototype (init вызывается при каждом создании бина,
            destroy не вызывается вовсе)

        <bean id="myPet"
          class="com.example.springcourse.introduction.Dog"
          init-method="init"
          destroy-method="destroy"
          scope="prototype">
        </bean>
         */

        Cat myCat = context.getBean("myPet", Cat.class);
        myCat.say();

        Cat yourCat = context.getBean("myPet", Cat.class);


        context.close();

    }
}
