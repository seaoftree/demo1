package com.example.demo1.type;


import java.lang.reflect.Type;

/**
 * @author a58
 */
public interface SuperType {
     /**
      * 测试
      */
     default void test(){
          System.out.println(this.getClass().getSimpleName());

     }

}
