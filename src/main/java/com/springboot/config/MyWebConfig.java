package com.springboot.config;

import com.springboot.Interceptor.LoginInterceptor;
import com.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {


    /**
     * view映射器
     * @param registry
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/main").setViewName("dashboard");

    }

    /**
     * 国际化
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    /**
     * 实例化登陆的拦截器
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/main","/main.html","/list","/list.html");
    }


}
