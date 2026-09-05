package com.example.springcourse.hibernate_test.entity;

import jakarta.persistence.*;

/*
    Конфигурация связи между классом и таблицей в данном случае осуществляется с помощью Java аннотаций.
    Старый вариант - с помощью xml файла.
 */

@Entity // Аннотация говорит о том, что данный класс будет иметь отображение в базе данных
@Table(name="employees") // Аннотация говоит о том, к какой таблице именно мы привязываем класс
public class Employee {
    /*
    Entity класс - это Java класс, который отображает информацию определённой таблицы в Базе Данных
    (POJO класс, в котором используются Hibernate аннотации для связи класса с таблицей из базы).

    POJO (Plain Old Java Object) - класс, удовлетворяющий ряду условий:
        private поля, getter-ы, setter-ы, конструктор без аргументов и т.д.
     */

    /*
    Столбец PRIMARY KEY содержит уникальное значение и не может быть null.
    Аннотация @GeneratedValue описывает стратегию по генерации значений для столбца с PRIMARY KEY.

    GenerationType.IDENTITY полагается на автоувеличение столбца по правилам, прописанным в БД.
    Есть ещё GenerationType.AUTO, GenerationType.SEQUENCE, GenerationType.TABLE, но это не нужно.

     */
    @Id // Аннотация говорит о том, что в таблице, столбец связанный с данным полем является PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Аннотация говорит о том, к какому именно столбцу из таблицы мы привязываем поле класса
    private int id;
    @Column(name = "name") // Аннотация говорит о том, к какому именно столбцу из таблицы мы привязываем поле класса
    private String name;
    @Column(name = "surname") // Аннотация говорит о том, к какому именно столбцу из таблицы мы привязываем поле класса
    private String surname;
    @Column(name = "department") // Аннотация говорит о том, к какому именно столбцу из таблицы мы привязываем поле класса
    private String department;
    @Column(name = "salary") // Аннотация говорит о том, к какому именно столбцу из таблицы мы привязываем поле класса
    private int salary;

    public Employee(){
    }

    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
