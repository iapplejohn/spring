/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: AopTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/6/15 14:15
 * Description: 
 */
package com.jemmy.spring.deeper.ch07;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AopTest
 *
 * @author Cheng Zhujiang
 * @date 2017/6/15
 */
@Aspect
public class AspectJTest {

    @Pointcut("execution(* *.test(..))")
    public void test() {

    }

    @Before("test()")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @After("test()")
    public void afterTest() {
        System.out.println("afterTest");
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint pjp) {
        Object o = null;
        System.out.println("before1");
        try {
            o = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/deeper/ch12/aspectj-test.xml");
        TestService testService = ctx.getBean("testService", TestService.class);
        testService.test();
    }
}
