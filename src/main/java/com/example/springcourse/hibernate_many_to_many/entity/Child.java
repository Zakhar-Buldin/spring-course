package com.example.springcourse.hibernate_many_to_many.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "children")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @ManyToMany(cascade =
            {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY)
    @JoinTable(name = "child_section",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    /*
        Join Table - это таблица, которая отображает связь между строками 2-х других таблиц
        Столбцы Join Table - это Foreign Key, которые ссылаются на Primary Key связываемых таблиц.

        В  аннотации @JoinTable:
         1) прописываем название Join Table таблицы
         2) в joinColumns указываем столбец JoinTable, который ссылается на Primary Key source таблицы
         3) в inverseJoinColumns указываем столбец JoinTable, который ссылается на Primary Key target таблицы
     */
    private List<Section> sections;

    public Child(){
    }

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSections() {
        return sections;
    }

    @Override
    public String toString() {
        return "Child{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public void addSectionToChild(Section section){
        if (sections == null){
            sections = new ArrayList<>();
        }

        sections.add(section);

    }
}
