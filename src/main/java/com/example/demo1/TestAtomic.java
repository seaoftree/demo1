package com.example.demo1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author a58
 */
public class TestAtomic {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        while(i.intValue() < 100){
            new Thread(() -> {
                synchronized (i.getClass()){
                    i.getAndIncrement();
                    System.out.println(Thread.currentThread().getName() + ":" + i.intValue());
                }
            }).start();
        }

    }
}
