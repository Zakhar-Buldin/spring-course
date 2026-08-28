package com.example.springcourse.introduction;

public class Cat implements Pet{
    private String name;

    public Cat(){
        System.out.println("Cat bean is created!");
    }

    @Override
    public void say() {
        System.out.println("Mew-mew");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Class Cat: set name");
        this.name = name;
    }
}
