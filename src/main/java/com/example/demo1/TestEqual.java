package com.example.demo1;

public class TestEqual {
    public static void main(String[] args) {
        String tenant = null;
        //推荐将常量放在equals的前面，这样可以避免空指针异常
        System.out.println("".equals(null));
        System.out.println(tenant.equals(""));
    }
}
