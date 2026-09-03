package com.example.springcourse.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* get*())") // В кавычках указываем Pointcut выражение
    public void allGetMethods() {
        // Выносим Pointcut -ы в отдельный класс и ставим public

        /*
        Если при вызове 1-го метода с бизнес-логикой срабатывают несколько Advice -ов,
        то нет никакой гарантии в порядке выполнения этих Advice -ов.

        Для соблюдения порядка такие Advice -ы нужно распределять по отдельным упорядоченным Aspect -ам.
        (Упорядочивание Aspect -ов делается за счёт аннотации @Order)
         */
    }
}
