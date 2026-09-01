package com.example.springcourse.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // Конфигурационный класс, который будет сканировать бины и зависимости из пакета
@ComponentScan("com.example.springcourse.aop") // Указываем путь пакета
@EnableAspectJAutoProxy // Позволяет нам за кулисами использовать Spring AOP Proxy
public class MyConfig {
    /*
    AOP (Аспектно Ориентированное Программирование) - это парадигма программирования, основанная на идее
    разделения основного и служебного функционала. Служебный функционал описывается в Aspect-классе.

    AOP Proxy — это объект-посредник между клиентским кодом и целевым объектом,
    который перехватывает вызовы методов и добавляет дополнительную логику.
     */
}
