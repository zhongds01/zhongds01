package com.example.springboot;

import com.example.springboot.bean.Person;
import com.example.springboot.exception.DException;
import com.example.springboot.service.PrivilegeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.rmi.RemoteException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Person person;

    @Autowired
    private ApplicationContext ac;

    @Autowired
    private PrivilegeService privilegeService;
    @Test
    public void contextLoads() {
    }

    @Test
    public void testPerson() {
        System.out.println(person);
    }

    @Test
    public void testConfigClass() {
        System.out.println(ac.containsBean("HelloService.class"));
    }

    @Test
    public void testLog() {
        logger.trace("trace日志");
        logger.error("trace日志");
    }

    /**
     * 测试自定义异常
     */
    @Test
    public void testDException() {

        System.out.println("begin ...");
        try {
            fun1();

        } catch (DException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause().getMessage());
            e.printStackTrace();
        }
        System.out.println("end ...");

    }

    private void fun1() throws DException {
		DException e = new DException(new RemoteException("抛出异常"));
		throw e;
    }
}
