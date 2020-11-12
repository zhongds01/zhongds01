package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
public class SpringbootApplication {

	public static PathMatchingResourcePatternResolver prpr;

	public static void main(String[] args) throws Exception{
		SpringApplication.run(SpringbootApplication.class, args);
		if (prpr == null) {
			prpr = new PathMatchingResourcePatternResolver();
		}
//		PathMatchingResourcePatternResolver resolver =
		Resource[] resources = prpr.getResources("classpath*:Log4j-charsets.properties");
		for (Resource resource : resources) {
			System.out.println(resource.getURL().getPath());
		}
	}

}
