package com.example.springboot;

import com.example.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private Person person;

	@Autowired
	private ApplicationContext ac;

	@Test
	public void contextLoads() {

	}
	@Test
	public void testPerson(){
		System.out.println(person);
	}
	@Test
	public void testConfigClass(){
		System.out.println(ac.containsBean("HelloService.class"));
	}
	@Test
	public void testLog(){
		logger.trace("trace日志");
	}
}
