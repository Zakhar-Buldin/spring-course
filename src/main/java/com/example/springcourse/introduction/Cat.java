package com.example.springcourse.introduction;

public class Cat implements Pet{

    public Cat(){
        System.out.println("Cat bean is created!");
    }

    @Override
    public void say() {
        System.out.println("Mew-mew");
    }

}
