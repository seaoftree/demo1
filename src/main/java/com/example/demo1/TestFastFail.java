package com.example.demo1;

import java.util.*;

/**
 * @author a58
 */
public class TestFastFail {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        int temp = 0;
        while (it.hasNext()) {
            if (temp == 3) {
                temp++;
                list.remove(3);
            } else {
                temp++;
                System.out.println(it.next());
            }
        }
        System.out.println("测绘" + "\r\n" + "e");
    }
}
