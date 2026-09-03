package com.example.springcourse.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(30) // Аннотация упорядочивает Aspect -ы (чем меньше число, тем выше приоритет)
public class ExceptionHandlingAspect {

    @Before("com.example.springcourse.aop.aspects.MyPointcuts.allGetMethods()")
    public void beforeGetExceptionHandlingAdvice(){
        System.out.println("beforeGetExceptionHandlingAdvice(): ловим/обрабатываем исключения при попытке получить книгу/журнал");
    }
}
