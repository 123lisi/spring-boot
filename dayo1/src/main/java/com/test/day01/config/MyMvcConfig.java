package com.test.day01.config;

import com.test.day01.component.LoginHandlerInterceptor;
import com.test.day01.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.*;

//@EnableWebMvc
//添加配置文件
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //注册拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/test","/","/index.html","/login");
//    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        registry.addViewController("/test").setViewName("success");
        //现在的写法
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/dashboard.html").setViewName("dashboard");
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
