package com.example.demo1.Java8;

import lombok.Data;
import org.junit.Test;

import java.util.Optional;

/**
 * @author a58
 */
public class OptionalTest {
    @Data
    class Person{
        private String name;
        private Integer age;
        private Car car;
    }
    @Data
    class Car{
        private String name;
        private Integer price;
    }

    public Person getPerson(){
        Person person = new Person();
        person.setAge(10);
        Car car = new Car();
        car.setName("baoma");
        car.setPrice(350000);
        person.setCar(car);
        person.setName("sea");
        return null;
    }
    @Test
    public void testOptional1(){
        Integer integer = Optional.ofNullable(getPerson()).map(Person::getCar).map(Car::getPrice).orElse(null);
        System.out.println(integer);
    }
}
