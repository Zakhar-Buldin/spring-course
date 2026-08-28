package com.example.springcourse.introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml"); //Spring Container

        /*
        DI: внедрение зависимостей и других значений из myApp.properties
                person.surname = Perova
                person.name = 19

        При создании класса Person автоматически создается объект класса Pet, и в Person передается ссылка на этот объект.
        Дальше при помощи сеттеров полям класса Person присваются значения (value), которые берутся из properties файла.

        <context:property-placeholder location="classpath:myApp.properties"/> (указываем путь к файлу со свойствами)
        <bean id="myPerson"
              class="com.example.springcourse.introduction.Person">
            <property name="pet" ref="myPet"/>
            <property name="surname" value="${person.surname}"/>
            <property name="age" value="${person.age}"/>
        </bean>

        Называть свойства в properties файле можно как угодно, необязательно "person.age и person.surnamw"
        Хоть "abc". Это просто хороший тон!
         */

        Person person = context.getBean("myPerson", Person.class);

        /*
            За кулисами:
                Cat myPet = new Cat();
                Person myPerson = new Person();
                Person.setPet(myPet);
                Person.setSurname("Perova");
                Person.setAge(19);
         */

        person.callYourPet();
        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        context.close(); // Обязательно закрывать контекст!!!
    }
}
