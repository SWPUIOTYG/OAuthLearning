package com.swpu.uchain.oauth2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * spring 容器配置 相当于Application.context
 */
@Configuration
@ComponentScan(basePackages = "com.swpu.uchain.oauth2",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)}) //排除Controller的扫描
public class ApplicationConfig {
    //配置除了Controller的其他bean，比如数据库连接池、业务bean等
}
