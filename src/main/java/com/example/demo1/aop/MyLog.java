package com.example.demo1.aop;

import java.lang.annotation.*;

/**
 * @author a58
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyLog {

}
