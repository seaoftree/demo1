package com.example.demo1.thread;

public class Main4 {
    public static void main(String[] args) throws Exception {
        AddThread4 add = new AddThread4();
        DecThread4 dec = new DecThread4();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }
}

class Counter4 {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();
    public static       int    count = 0;
}

class AddThread4 extends Thread {
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            synchronized (Counter4.lock1) {
                Counter4.count += 1;
            }
        }
    }
}

class DecThread4 extends Thread {
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            synchronized (Counter4.lock2) {
                Counter4.count -= 1;
            }
        }
    }
}

