package com.example.springcourse.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(10) // Аннотация упорядочивает Aspect -ы (чем меньше число, тем выше приоритет)
public class LoggingAspect {

    @Before("com.example.springcourse.aop.aspects.MyPointcuts.allGetMethods()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: логирование попытки получить книгу/журнал");
    }

}
