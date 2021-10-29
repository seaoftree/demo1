package com.example.demo1.dynamic_proxy;

import lombok.Data;

@Data
public class UserServiceImpl implements UserService{
    @Override
    public String getName(int id) {
        System.out.println("-----------getName--------");
        return "liugan01";
    }

    @Override
    public Integer getAge(int id) {
        System.out.println("----------getAge---------");
        return 25;
    }
}
