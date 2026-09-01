package com.example.springcourse.introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration // Аннотация означает, что данный класс является конфигурацией
@PropertySource("classpath:myApp.properties") // Указывает properties файл, в котором хранятся значения для полей
public class MyConfig {

    // Внутри класса описываем все бины и прописываем зависимости

    /* Если scope = singleton, бин создастя единожды, а getBean просто будет возвращать ссылку.
    Т.е. тело этого метода выполнится один раз,
    а дальше аннотация @Bean будет перехватывать вызов метода.
    */
    @Bean
    @Scope("singleton")
    public Pet catBean() { // Название метода - это id бина!
        return new Cat();
    }

    @Bean
    public Person personBean(){ // Название метода - это id бина!
        return new Person(catBean()); // Внедрение зависимости через конструктор
    }

}
