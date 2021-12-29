package com.example.demo1.thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1);
        // 中断一个线程，只需要在其他线程中对目标线程调用interrupt()方法，
        // 目标线程需要反复检测自身状态是否是interrupted状态，如果是，就立刻结束运行。
        // interrupt()方法仅仅向myThread线程发出了“中断请求”，至于myThread线程是否能立刻响应，要看具体代码。
        myThread.interrupt();
        myThread.join();
        System.out.println("end");
    }
}

class MyThread extends Thread {
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + "hello");
        }
        System.out.println("被打断");
    }
}