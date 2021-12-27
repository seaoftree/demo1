package com.example.demo1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        People      zhangsan  = new People("zhangsan1", 24);
        People      zhangsan1 = new People("zhangsan", 23);
        Set<People> set       = new HashSet<>();
        set.add(zhangsan1);
        set.add(zhangsan);
        System.out.println(set.size());
    }
}
