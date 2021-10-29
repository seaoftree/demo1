package com.example.demo1.Java8;

import org.junit.Test;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TestSupplier {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> new Random().nextInt();
        System.out.println(supplier.get());
        System.out.println("********************");
    }

    /**
     * Supplier接口测试2，使用需要Supplier的接口方法
     */
    @Test
    public void test_Supplier2() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        //返回一个optional对象
        Optional<Integer> first = stream.filter(i -> i > 4)
                .findFirst();

        //optional对象有需要Supplier接口的方法
        //orElse，如果first中存在数，就返回这个数，如果不存在，就放回传入的数
        System.out.println(first.orElse(1));
        System.out.println(first.orElse(7));

        System.out.println("********************");

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                //返回一个随机值
                return new Random().nextInt();
            }
        };

        //orElseGet，如果first中存在数，就返回这个数，如果不存在，就返回supplier返回的值
        System.out.println(first.orElseGet(supplier));
    }
}
