package com.example.springcourse.aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {

    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        Student st1 = new Student(8.3, 4 , "Захар Бульдин");
        Student st2 = new Student(9.1, 3, "Виктория Перова");
        Student st3 = new Student(9.5, 1, "Ярослав Барышев");

        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents(){
        System.out.println("Начало работы метода getStudents");
        System.out.println(students.get(5)); // Обращаемся к несуществующему элементу (некорректный индекс)
        System.out.println("getStudents: Возвращаем список студентов университета");
        return students;
    }
}
