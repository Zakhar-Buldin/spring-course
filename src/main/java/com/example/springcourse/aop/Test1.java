package com.example.springcourse.aop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class); // Создание и запуск Spring контейнера

        University university = context.getBean("university", University.class);
        university.addStudents();
        List<Student> students = university.getStudents();
        students.forEach(System.out::println);

        context.close();
    }
}
