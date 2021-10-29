package com.example.demo1.dynamic_proxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws Throwable {
        UserServiceImpl userService = new UserServiceImpl();
        MyInvocationHandler userServiceHandler = new MyInvocationHandler(userService);
        UserService proxy = (UserService) userServiceHandler.getProxy();

        proxy.getName(25);
        System.out.println("*******************************************");
        proxy.getAge(25);
    }
}
