package com.example.demo1;

public class TestEqual {
    public static void main(String[] args) {
//        String tenant = null;
//        //推荐将常量放在equals的前面，这样可以避免空指针异常
//        System.out.println("".equals(null));
//        System.out.println(tenant.equals(""));

        String [] arr = new String[0];
        String ans = joinStr(arr);
        System.out.println(ans == null);
    }
    public static String joinStr(String... strs) {
        if (null == strs) {
            return null;
        }

        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }

        return res.toString();
    }
}
