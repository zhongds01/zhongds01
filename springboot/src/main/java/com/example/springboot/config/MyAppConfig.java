package com.example.springboot.config;

import com.example.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * description: @Configuration说明此类是一个配置类,优先加载
 * author: ZDS
 * create_date : 2019/3/26
 * create_time : 14:20
 */
@Configuration
@EnableAspectJAutoProxy
public class MyAppConfig {
    //使用@Bean注解说明这是一个bean方法名为bena的id，返回值为bean的实例

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }

}
