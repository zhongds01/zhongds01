package com.example.springboot.config;

import com.example.springboot.interceptor.PrivilegeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description: please add the description
 * Author: zhongds
 * Date : 2020/8/2 22:23
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 注册拦截器
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PrivilegeInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html", "/webjars/**");
    }
}
