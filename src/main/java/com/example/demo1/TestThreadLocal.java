package com.example.demo1;

import com.example.demo1.Java8.Person;

/**
 * @author a58
 */
public class TestThreadLocal {
    static  ThreadLocal<Person> personInfo = ThreadLocal.withInitial(() -> {return new Person(26,"Lg");});
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i< 100 ;i++){
            new Thread(() -> {
                Person person = personInfo.get();
                System.out.println(Thread.currentThread().getName() + ":" + person.getAge());
                person.setAge(person.getAge() + 1);
            }).start();
        }
    }
}
