package com.example.springcourse.hibernate_many_to_many.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY)
    @JoinTable(name = "child_section",
            joinColumns = @JoinColumn(name = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    /*
        Join Table - это таблица, которая отображает связь между строками 2-х других таблиц
        Столбцы Join Table - это Foreign Key, которые ссылаются на Primary Key связываемых таблиц.


     */
    private List<Child> children;


   public Section(){
   }

    public Section(String name){
        this.name = name;
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

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void addChildToSection(Child child){
       if (children == null){
           children = new ArrayList<>();
       }
       children.add(child);
    }

    public List<Child> getChildren() {
        return children;
    }
}
