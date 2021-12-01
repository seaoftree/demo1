package com.example.demo1.type;

import org.junit.Test;

import java.lang.reflect.Type;

/**
 * @author a58
 */
public class TypeTest implements SuperType {
    @Test
    public void testType1(){
        test();
    }

//    @Override
//    public void test() {
//        Type[] interfaces = getClass().getGenericInterfaces();
//        Class<?>[] interfaces1 = getClass().getInterfaces();
//        System.out.println(interfaces[0].getTypeName());
//        System.out.println(interfaces1[0].getSimpleName());
//    }
}
