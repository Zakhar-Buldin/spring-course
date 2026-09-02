package com.example.springcourse.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {
    // Aspect - это класс, отвечающий за сквозную (служебную) функциональность: логирование, транзакции БД и т.д.
    /*
        Advice - метод, который находится в Aspect-е и содержит сквозную логику.
        Advice определяет, что и когда должно происходить.
        Pointcut - это выражение, описывающее, где должен быть применён Advice
     */
     /*
        execution(
            modifiers-pattern?          // модификатор доступа (необязательно)
            return-type-pattern         // тип возвращаемого значения
            declaring-type-pattern?     // класс/тип, в котором объявлен метод (необязательно)
            method-name-pattern(parameters-pattern)  // имя метода и параметры
            throws-pattern?             // исключения, которые может бросать метод (необязательно)
        )

        ? — часть необязательна.
        * — любое значение.
        .. — любое количество параметров / пакетов, в зависимости от места использования.
     */

    @Pointcut("execution(* get*())") // В кавычках указываем Pointcut выражение
    private void allGetMethods() {
        /*
        Для того, чтобы не использовать copy-paste, когда для нескольких Advice - ов подходит один и тот же
        Pointcut, есть возможность объявить данный Pointcut и затем его использовать несколько раз.

        Тело метода allGetMethods должно быть пустым, т.к. он просто ссылается на Pointcut выражение
         */
    }


    @Before("allGetMethods()") // Указываем ссылку на Pointcut
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: попытка получить книгу/жунал");
    }

    @Before("allGetMethods()") // Указываем ссылку на Pointcut
    public void beforeGetSecurityAdvice(){
        System.out.println("beforeGetSecurityAdvice: проверка прав на получение книги/журнала");
    }
}
