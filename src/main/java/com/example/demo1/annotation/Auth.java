package com.example.demo1.annotation;

import java.lang.annotation.*;

/**
 * @author a58
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Auth {
    String pid() default "";
}
