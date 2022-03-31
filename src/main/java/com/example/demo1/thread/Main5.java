package com.example.demo1.thread;

public class Main5 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("sea");
        });
        thread.start();
    }
}
