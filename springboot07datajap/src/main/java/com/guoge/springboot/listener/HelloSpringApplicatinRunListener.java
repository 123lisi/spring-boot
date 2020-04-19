package com.guoge.springboot.listener;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class HelloSpringApplicatinRunListener implements SpringApplicationRunListener {
    public HelloSpringApplicatinRunListener(SpringApplication application, String[] args) {

    }

    //SpringApplicationRunListener开始运行
    @Override
    public void starting() {
        System.out.println("SpringApplicationRunListener .. starting");
    }
    //SpringApplicationRunListener准备好运行环境
    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        //获取系统的环境
        Object o = environment.getSystemProperties().get("os.name");
        System.out.println("SpringApplicationRunListener ... environmentPrepared" + o);
    }
    //ioc已经准备好了
    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...contextPrepared");
    }
    //加载ioc容器
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }
    //开始运行
    @Override
    public void running(ConfigurableApplicationContext context) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        System.out.println("SpringApplicationRunListener..." + beanFactory);
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
