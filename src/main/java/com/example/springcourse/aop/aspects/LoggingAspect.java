package com.example.springcourse.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
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

    @Before("execution(public void getBook())") // Выполняется ДО метода с основной логикой (в данном случае ПЕРЕД getBook())
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }

    @Before("execution(public void return*())") // Любой метод, начинающийся на return
    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу");
    }

    /*
    Звёздочкой "*" можно также обозначить любой возвращаемый тип:
        @Before("execution(public * returnMagazine())")

    @Before("execution(public void com.example.springcourse.aop.SchoolLibrary.getBook())")
    Можно указывать метод из конкретного класса.
     */


    @Before("execution(public void getMagazine(String))") // Указываем КОНКРЕТНЫЙ тип параметра
    public void beforeGetMagazineAdvice(){
        System.out.println("beforeGetMagazineAdvice: попытка взять журнал");
    }

    @Before("execution(public void getMagazine(..))") // ПРОИЗВОЛЬНОЕ кол-во параметров ПРОИЗВОЛЬНОГО типа
    public void beforeGetUniMagazineAdvice(){
        System.out.println("beforeGetUniMagazineAdvice: попытка взять журнал");
    }

    @Before("execution(public void getCustomBook(com.example.springcourse.aop.Book))") // Параметр КАСТОМНОГО класса (необходимо указывать пакет)
    public void beforeGetCustomBookAdvice(){
        System.out.println("beforeGetCustomBookAdvice: попытка взять книгу");
    }


}
