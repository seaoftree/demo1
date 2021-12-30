package com.example.demo1.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Main3 {
    public static void main(String[] args) throws Exception {
        AddThread add = new AddThread();
        DecThread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
//        System.out.println(Counter.count);
        System.out.println(Counter.count.intValue());
    }
}

class Counter {
    //    public static int count = 0;
    public static AtomicInteger count = new AtomicInteger(0);
}

class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
//            Counter.count += 1;
            Counter.count.incrementAndGet();
        }

    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
//            Counter.count -= 1;
            Counter.count.decrementAndGet();
        }

    }
}

