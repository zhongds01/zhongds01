package com.example.springboot.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NotVeryUsefulAspect {
    private static final String EXECUTION = "execution(* com.example.springboot.service..*.*(..))";

    @Pointcut(EXECUTION)
    public void doAspect() {
        System.out.println("++++++");
    }

    @Before(value = "doAspect()")
    public void doBefore() {
        System.out.println("before...");
    }

    @After(value = "doAspect()")
    public void doAfter() {
        System.out.println("after...");
    }
}
