package com.example.springcourse.aop.aspects;

import com.example.springcourse.aop.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
    public void afterReturningGetStudentLoggingAdvice(List<Student> students){

        /*
        @AfterReturning Advice выполняется только ПОСЛЕ НОРМАЛЬНОГО ОКОНЧАНИЯ метода с основной логикой,
        но до присвоения результата этого метода какой-либо переменной. Поэтому с помощью @AfterReturning
        можно ИЗМЕНЯТЬ возвращаемый РЕЗУЛЬТАТ метода (в данном случае изменяется результат getStudents())
         */

        // Имя параметра метода afterReturningGetStudentLoggingAdvice и returning должно быть одинаковым!!!

        // students - это результат работы метода с основной логикой

        // P.s. JoinPoint описывает точку вызова, но не хранит результат выполнения метода.

        Student firstStudent = students.getFirst();
        String nameSurname = firstStudent.getNameSurname();
        nameSurname = "Mrs. " + nameSurname;
        firstStudent.setNameSurname(nameSurname);

        double avgGrade = firstStudent.getAvgGrade();
        avgGrade += 1;
        firstStudent.setAvgGrade(avgGrade);

        System.out.println("afterReturningGetStudentLoggingAdvice: логируем получение списка студентов и " +
                "меняем информацию о первом студенте");
    }

    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
    public void afterThrowingGetStudentLoggingAdvice(Throwable exception){

        /*
        @AfterThrowing Advice выполняется после аварийного завершения работы методы,
        т.е. если было выброшено исключение.

        @AfterThrowing Advice НЕ ВЛИЯЕТ на протекание программы при выбрасывании исключения.
        С помошью @AfterThrowing Advice можно получить доступ к исключению,
        которое выбросилось из метода с основной логикой (в данном случае из getStudents)

        Имя параметра метода afterThrowingGetStudentLoggingAdvice должно быть таким же, как и в throwing!
         */
        System.out.println("afterThrowingGetStudentLoggingAdvice: логируем выброс исключения " + exception);
    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(JoinPoint joinPoint){
        /*
        @After Advice выполняется после окончания метода с основной логикой вне зависимости от того,
        завершается ли метод нормально или выбрасывается исключение (этот Advice похож на finally).

        С помощью @After Advice невозможно:
            1) получить доступ к исключению, которое выбросилось из метода с основной логикой
            2) получить доступ к возвращаемому методом результату

        Но благодаря JoinPoint можно получить сигнатуру метода с бизнес-логикой (основную информацию о нём).
         */

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("afterGetStudentsLoggingAdvice (после " + methodSignature.getName() +") : логируем нормальное окончание работы метода " +
                "или аварийное завершение (выброс исключения)");
    }
}
