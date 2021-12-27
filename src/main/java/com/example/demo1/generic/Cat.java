package com.example.demo1.generic;

/**
 * @author a58
 */
public class Cat extends Animal{
    @Override
    public void eat(String food) {
        super.eat(food);
        System.out.println("fish");
    }

    @Override
    public void run() {
        super.run();
        System.out.println("cat run");
    }
}
