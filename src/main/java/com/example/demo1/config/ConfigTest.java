package com.example.demo1.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author a58
 */
@ConfigurationProperties(prefix = "my")
@Configuration
@Component
@Getter
@Setter
public class ConfigTest {
    private List<String> servers;
    String name;
}
