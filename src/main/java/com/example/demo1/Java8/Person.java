package com.example.demo1.Java8;

import lombok.Data;

@Data
public class Person {
    private Integer age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
