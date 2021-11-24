package com.example.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


/**
 * @author a58
 */
public class TestThread {
    public static void main(String[] args) throws Exception {
        TestCallable testCallable = new TestCallable();
        FutureTask futureTask = new FutureTask(testCallable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

        System.out.println("-----------------------------------");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new TestExecutors());
        executorService.execute(new TestExecutors());
        executorService.shutdown();
    }

    /**
     * 测试Callable
     *
     * @author a58
     */
    static class TestCallable implements Callable {
        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                sum += i;
            }
            return sum;

        }

    }

    /**
     * 测试Executors
     */
    static class TestExecutors implements Runnable {

        @Override
        public void run() {
            System.out.println("give me a sea");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + "sea is come");
        }
    }
}
