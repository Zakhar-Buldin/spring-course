package com.example.springcourse.introduction;

public class Cat implements Pet{

    public Cat(){
        System.out.println("Cat bean is created!");
    }

    @Override
    public void say() {
        System.out.println("Mew-mew");
    }

    public void init(){
        System.out.println("Class Cat: init method");
    }

    public void destroy(){
        System.out.println("Class Cat: destroy method");
    }
}
