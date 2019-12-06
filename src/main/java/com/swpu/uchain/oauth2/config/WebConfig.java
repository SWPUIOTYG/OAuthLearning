package com.swpu.uchain.oauth2.config;

import com.swpu.uchain.oauth2.interceptor.SimpleAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 这个配置相当于springmvc.xml文件
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.swpu.uchain.oauth2"
        ,includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class WebConfig implements WebMvcConfigurer {
    //视图解析器

    @Autowired
    private SimpleAuthenticationInterceptor simpleAuthenticationInterceptor;
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/"); //指定前缀
        viewResolver.setSuffix(".jsp");
        return viewResolver;//后缀
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //选择拦住的地址
        registry.addInterceptor(simpleAuthenticationInterceptor).addPathPatterns("/r/**");
    }
}
