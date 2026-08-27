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
                  <constructor-arg ref="myPet">
                  </constructor-arg>
            </bean>
         */

        Person person = context.getBean("myPerson", Person.class);

        /*
            За кулисами:
                Cat myPet = new Cat();
                Person myPerson = new Person(myPet);
         */
        person.callYourPet();

        context.close(); // Обязательно закрывать контекст!!!
    }
}
