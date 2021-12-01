package com.example.demo1;

import com.example.demo1.util.JSONUtil;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class TestJson {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("lisi",23);
        map.put("houkaikai","dashabi");
        String houkai = JSONUtil.toJSONString(new Person("houkai",map));
        System.out.println(houkai);
    }
}
@AllArgsConstructor
class Person{
    private String name;

    private Map<String,Object> map;
}