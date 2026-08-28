package com.example.springcourse.introduction;

public class Dog implements Pet {
    private String name;


    public Dog(){
        System.out.println("Dog bean is created!");
    }

    @Override
    public void say(){
        System.out.println("Bow-wow");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        System.out.println("Class Dog: set name");
        this.name = name;
    }
}
