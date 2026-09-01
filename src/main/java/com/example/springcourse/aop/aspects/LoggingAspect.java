package com.example.springcourse.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    // Aspect - это класс, отвечающий за сквозную (служебную) функциональность: логирование, транзакции БД и т.д.

    @Before("execution(public void getBook())") // Выполняется ДО метода с основной логикой (в данном случае ПЕРЕД getBook())
    public void beforeGetBookAdvice(){
        /*
        Advice - метод, который находится в Aspect-е и содержит сквозную логику.
        Advice определяет, что и когда должно происходить.
        Pointcut - это выражение, описывающее, где должен быть применён Advice
         */
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }
}
