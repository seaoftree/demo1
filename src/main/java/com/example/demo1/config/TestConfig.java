package com.example.demo1.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * https://blog.csdn.net/weixin_43899069/article/details/118107179?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_title~default-0.no_search_link&spm=1001.2101.3001.4242.1
 */
@RunWith(SpringRunner.class) //指让类运行在Spring的测试环境，以便测试开始时自动创建Spring应用上下文
@Component
@SpringBootTest
public class TestConfig {
    @Autowired
    ConfigTest configTest;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void setConfigTest(){
        System.out.println(this.configTest.name);
        System.out.println(configTest.getServers());
    }
}
