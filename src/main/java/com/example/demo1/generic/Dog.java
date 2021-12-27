package com.example.demo1.generic;

/**
 * @author a58
 */
public class Dog extends Animal{
    @Override
    public void eat(String food) {
        super.eat(food);
        System.out.println("meat");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("dog run");
    }
}
