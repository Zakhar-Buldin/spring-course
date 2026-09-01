package com.example.springcourse.introduction;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Аннотация означает, что данный класс является конфигурацией
@ComponentScan("com.example.springcourse.introduction") // Указываем, какой пакет нужно сканировать на наличие бинов и аннотаций
public class MyConfig {
    /*
    Данный класс заменяет xml файл:
        <context:component-scan base-package="com.example.springcourse.introduction"/>
     */
}
