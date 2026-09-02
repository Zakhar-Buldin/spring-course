package com.example.springcourse.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.security.PublicKey;

@Component
@Aspect
public class LoggingAndSecurityAspect {

    @Pointcut("execution(* com.example.springcourse.aop.UniLibrary.get*())") // В кавычках указываем Pointcut выражение
    private void allGetMethodsFromUniLibrary() {
        /*
        Для того, чтобы не использовать copy-paste, когда для нескольких Advice -ов подходит один и тот же
        Pointcut, есть возможность объявить данный Pointcut и затем его использовать несколько раз.

        Тело метода allGetMethods должно быть пустым, т.к. он просто ссылается на Pointcut выражение
         */
    }

    @Pointcut("execution(* com.example.springcourse.aop.UniLibrary.return*())")
    private void allReturnMethodsFromUniLibrary(){}

    // Комбинирование Pointcut -ов - это их объединение с помощью логических операторов &&, ||, !

    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()") // Комбинация Pointcut -ов (ИЛИ)
    private void allGetAndReturnMethodsFromUniLibrary() {}



    @Pointcut("execution(* com.example.springcourse.aop.UniLibrary.*(..))")
    private void allMethodsFromUniLibrary(){}

    @Pointcut("execution(public void com.example.springcourse.aop.UniLibrary.returnMagazine())")
    private void returnMagazineFromUniLibrary(){}

    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()") // Комбинация Pointcut -ов (И + НЕ: ВСЁ КРОМЕ...)
    private void allMethodsExceptReturnMagazineFromUniLibrary(){}



    @Before("allGetMethodsFromUniLibrary()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: writing Log №1");
    }

    @Before("allReturnMethodsFromUniLibrary()")
    public void beforeReturnLoggingAdvice(){
        System.out.println("beforeReturnLoggingAdvice: writing Log №2");
    }

    @Before("allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetAndReturnLoggingAdvice(){
        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log №3");
    }

    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
    public void beforeAllMethodsExceptReturnMagazineAdvice(){
        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: writing Log №666");
    }

}
