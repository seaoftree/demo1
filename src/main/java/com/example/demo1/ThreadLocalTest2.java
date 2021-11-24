package com.example.demo1;

import com.example.demo1.Java8.Person;
import org.springframework.context.annotation.Import;

/**
 * @author a58
 */
@Import(Person.class)
public class ThreadLocalTest2 {

    //(1)创建ThreadLocal变量
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        //在main线程中添加main线程的本地变量
        threadLocal.set("mainVal");
        //新创建一个子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程中的本地变量值:"+threadLocal.get());
            }
        });
        thread.start();
        //输出main线程中的本地变量值
        System.out.println("main线程中的本地变量值:"+threadLocal.get());
    }
}
//answer
//main线程中的本地变量值:mainVal
//子线程中的本地变量值:null

