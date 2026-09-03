package com.example.springcourse.aop.aspects;

import com.example.springcourse.aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(10) // Аннотация упорядочивает Aspect -ы (чем меньше число, тем выше приоритет)
public class LoggingAspect {

    @Before("com.example.springcourse.aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint){
        /*
        Прописав JoinPoint в параметре метода Advice, мы получаем доступ к информации о сигнатуре и параметрах
        метода с бизнес-логикой.
         */

        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")){
            Object[] arguments = joinPoint.getArgs(); // Аргументы метода
            for(Object obj: arguments){
                if (obj instanceof Book myBook){
                    System.out.println("Информация о книге: " +
                            "название - " + myBook.getName() + ", автор - " + myBook.getAuthor() +
                            ", год издания - " + myBook.getYearOfPublication());

                }
                else if (obj instanceof String){
                    System.out.println("Книгу в библиотеку добавляет " + obj);
                }
            }
        }

        System.out.println("beforeAddLoggingAdvice: логирование попытки получить книгу/журнал");
        System.out.println("-----------------------------------------------------------------------");

    }

}
