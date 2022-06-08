package com.learn.online.question;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<List<Integer>> wall= new ArrayList<>();
    private String name;
    private String age;
    private String gender;

    public List<List<Integer>> getWall() {
        return wall;
    }

    public void setWall(List<List<Integer>> wall) {
        this.wall = wall;
    }

    public Person() {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        this.wall.add(list);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
