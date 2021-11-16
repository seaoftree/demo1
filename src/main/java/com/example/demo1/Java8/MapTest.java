package com.example.demo1.Java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @author a58
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("sea","25");
        map.put("sky","26");
        map.forEach((key,value) -> {
            System.out.println(value);
        });
    }
}
