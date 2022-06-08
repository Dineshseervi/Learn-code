package com.learn.online.question;

public class Student extends User {
    private String name;
    private int age;

    //static block
    static {
        System.out.println("SSS student class static block ");
    }

    //initializer block
    {

        System.out.println("III student class initializer block ----------");
    }


    public Student(String name, int age) {
        System.out.println("constructor is called");
        this.name = name;
        this.age = age;
    }


}
