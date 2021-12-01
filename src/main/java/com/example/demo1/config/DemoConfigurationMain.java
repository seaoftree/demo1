package com.example.demo1.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author a58
 */

@RunWith(SpringRunner.class) //指让类运行在Spring的测试环境，以便测试开始时自动创建Spring应用上下文
@Component
@SpringBootTest
public class DemoConfigurationMain {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void test() {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(DemoClass.class);
        System.out.println(acac.getBean(DemoClass.class));

//        DemoClass bean = applicationContext.getBean(DemoClass.class);
//        System.out.println(bean.getClass().getSimpleName());

//        DemoConfigration bean = acac.getBean(DemoConfigration.class);
//        bean.getDemoClass().say();
    }
}
