package com.example.demo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author a58
 * 任何一个标注了@Configuration的Java类定义都是一个JavaConfig配置类。
 * 而在这个配置类中，任何标注了@Bean的方法，它的返回值都会作为Bean定义注册到Spring的IOC容器，方法名默认成为这个bean的id
 *
 */
@Configuration
public class DemoConfigration {
    public DemoConfigration() {
    }

    @Bean
    public DemoClass getDemo1Class(){
        return  new DemoClass();
    }
}
