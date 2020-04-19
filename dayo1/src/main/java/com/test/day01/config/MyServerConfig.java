package com.test.day01.config;

import com.test.day01.filter.MyFilter;
import com.test.day01.listener.MyListener;
import com.test.day01.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.Arrays;
import java.util.EventListener;

@Configuration
public class MyServerConfig {
    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>(new MyServlet(),"/myservlet");
        return servletServletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new MyFilter());
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myservlet"));
        return filterFilterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<EventListener> listenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return listenerRegistrationBean;
    }
    //定制嵌入式的Servlet容器相关的规则
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8083);
            }
        };
    }
}
