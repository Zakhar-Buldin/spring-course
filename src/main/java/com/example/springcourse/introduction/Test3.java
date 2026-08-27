package com.example.springcourse.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); //Spring Container

        /*
            Pet pet = context.getBean("myPet", Pet.class);
            Создана зависимость в ApplicationContext.xml, поэтому получать объект из контейнера не нужно

            <bean id = "myPerson"
                class = "com.example.springcourse.introduction.Person">
                <property name= "pet" ref = "myPet">
                </property>
            </bean>

            pet -> Pet -> setPet (Конвертация name = "pet"): property name = "pet"
            (ref - это ссылка на bean myPet - объект класса Pet)
         */

        Person person = context.getBean("myPerson", Person.class);

        /*
            За кулисами:
                Cat myPet = new Cat();
                Person myPerson = new Person();
                Person.setPet(myPet);
         */
        person.callYourPet();

        context.close(); // Обязательно закрывать контекст!!!
    }
}
