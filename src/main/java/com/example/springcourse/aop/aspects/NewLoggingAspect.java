package com.example.springcourse.aop.aspects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        /*
        С помошью @AroundAdvice можно:
            1) произвести какие-либо действия до работы target метода;
            2) произвести какие-либо действия после работы target метода;
            3) получить результат работы target метода/изменить его;
            4) предпринять какие-либо действия, если из target метода выбрасывается исключение.


        ProceedingJoinPoint позволяет вручную запустить target метод (метод с основной логикой) внутри Advice -а.
        А также ProceedingJoinPoint может выполнять функционал обычного JoinPoint.
        */

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature(); // Получаем сигнатуру target метода
        Object targetMethodResult = null;

        long begin = System.currentTimeMillis();

        try {
            // Создаём исключение в UniLibrary.returnBook()
            targetMethodResult = proceedingJoinPoint.proceed(); // Вручную запускаем target метод и присваиваем результат переменной
        }
        catch (Exception e){
            System.out.println("Было поймано исключение " + e);
            throw e; // Пробрасываем исключение в main
        }
        long end = System.currentTimeMillis();

        targetMethodResult = targetMethodResult + " 2"; // Изменяем результат


        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
        System.out.println("aroundReturnBookLoggingAdvice: метод " + methodSignature.getName() +
                " выполнил работу за " + (end - begin) + " миллисекунд");

        return targetMethodResult;
    }
}
