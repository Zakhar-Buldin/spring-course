package com.example.springcourse.hibernate_one_to_many_bi.entity;

import com.example.springcourse.hibernate_one_to_one.entity.Detail;
import jakarta.persistence.*;

/*
    Конфигурация связи между классом и таблицей в данном случае осуществляется с помощью Java аннотаций.
    Старый вариант - с помощью xml файла.
 */

@Entity // Аннотация говорит о том, что данный класс будет иметь отображение в базе данных
@Table(name="employees") // Аннотация говоит о том, к какой таблице именно мы привязываем класс
public class Employee {

    @Id // Аннотация говорит о том, что в таблице, столбец связанный с данным полем является PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Аннотация говорит о том, к какому именно столбцу из таблицы мы привязываем поле класса
    private int id;

    @Column(name = "name") // Аннотация говорит о том, к какому именно столбцу из таблицы мы привязываем поле класса
    private String name;

    @Column(name = "surname") // Аннотация говорит о том, к какому именно столбцу из таблицы мы привязываем поле класса
    private String surname;

    @Column(name = "salary") // Аннотация говорит о том, к какому именно столбцу из таблицы мы привязываем поле класса
    private int salary;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE}) // Связь многие-к-одному
    @JoinColumn(name = "department_id") // Настройка внешнего ключа
    private Department department;

    Employee() {}

    public Employee(String name, String surname, int salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}