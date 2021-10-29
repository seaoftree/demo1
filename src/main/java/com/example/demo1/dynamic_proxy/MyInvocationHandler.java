package com.example.demo1.dynamic_proxy;

import lombok.Data;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Data
public class MyInvocationHandler implements InvocationHandler {
    Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("getName".equals(method.getName())){
            System.out.println("------------beforeGetName-------");
            Object result = method.invoke(target, args);
            System.out.println("-----------afterGetName---------");
            return result;
        }else{
            return method.invoke(target, args);
        }
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(),this);
    }
}
