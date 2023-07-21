package com.xiafish.config;

import com.xiafish.interceptor.AdminCheckInterceptor;
import com.xiafish.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//该类用于配置拦截器，对所有的请求路径进行拦截
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;
    @Autowired
    private AdminCheckInterceptor adminCheckInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").order(1);
        registry.addInterceptor(adminCheckInterceptor).addPathPatterns("/admin/**").order(2);
    }

}
