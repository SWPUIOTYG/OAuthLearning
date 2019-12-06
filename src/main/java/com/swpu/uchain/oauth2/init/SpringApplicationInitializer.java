package com.swpu.uchain.oauth2.init;

import com.swpu.uchain.oauth2.config.ApplicationConfig;
import com.swpu.uchain.oauth2.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //相当于加载applicationContext.xml
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};
    }
    //相当于加载springmvc.xml ServletContext
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //url mapping
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
