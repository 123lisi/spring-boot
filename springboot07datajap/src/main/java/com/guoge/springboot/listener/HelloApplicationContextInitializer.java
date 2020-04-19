package com.guoge.springboot.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
//实现监听功能
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {


    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println(" ApplicationContextInitializer... initialize ... configurableApplicationContext");
    }
}
