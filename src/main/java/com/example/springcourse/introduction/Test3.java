package com.example.springcourse.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); //Spring Container

        /*
         Зависимости для setSurname(String surname) и setAge(int age):

            <bean id="myPerson"
                  class="com.example.springcourse.introduction.Person">
                <property name="pet" ref="myPet"/>
                <property name="surname" value="Buldin"/>
                <property name="age" value="21"/>

            </bean>

        При создании класса Person автоматически создается объект класса Pet, и в Person передается ссылка на этот объект.
        Дальше при помощи сеттеров полям класса Person присваются значения (value): "Buldin" и 21


         */

        Person person = context.getBean("myPerson", Person.class);

        /*
            За кулисами:
                Cat myPet = new Cat();
                Person myPerson = new Person();
                Person.setPet(myPet);
                Person.setSurname("Buldin");
                Person.setAge(21); # ("21" -> 21)
         */
        person.callYourPet();

        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        context.close(); // Обязательно закрывать контекст!!!
    }
}
