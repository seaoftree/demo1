package com.example.demo1.dynamic_proxy;

import com.example.demo1.util.JSONUtil;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Throwable {
        UserServiceImpl userService = new UserServiceImpl();
        MyInvocationHandler userServiceHandler = new MyInvocationHandler(userService);
        UserService proxy = (UserService) userServiceHandler.getProxy();

        proxy.getName(25);
        System.out.println("*******************************************");
        proxy.getAge(25);
    }

    @Test
    public void testJson(){
        AttendeeParam attendeeParam = new AttendeeParam();
        attendeeParam.setBspIds(Arrays.asList("111","222"));
        attendeeParam.setGroupIds(Arrays.asList("333","444"));
        attendeeParam.setDepIds(Arrays.asList("555","666"));

        String s = JSONUtil.toJSONString(attendeeParam);
        System.out.println(s);

    }
}
