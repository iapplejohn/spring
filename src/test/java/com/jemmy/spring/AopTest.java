/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: AopTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/5/7 15:23
 * Description: 
 */
package com.jemmy.spring;

import com.jemmy.spring.chapter6.service.HelloWorldService;
import com.jemmy.spring.chapter6.service.IntroductionService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AopTest
 *
 * @author Cheng Zhujiang
 * @date 2017/5/7
 */
public class AopTest {

    @Test
    public void testHelloWorld() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/chapter6/base.xml");
        HelloWorldService helloWorldService = ctx.getBean("helloWorldService", HelloWorldService.class);
        helloWorldService.sayHello();
    }

    @Test
    public void testSchemaBeforeAdvice() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/chapter6/before.xml");
        HelloWorldService helloWorldService = ctx.getBean("helloWorldService", HelloWorldService.class);
        helloWorldService.sayBefore("I am the param");
    }

    @Test
    public void testSchemaAfterReturningAdvice() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/chapter6/after-returning.xml");
        HelloWorldService helloWorldService = ctx.getBean("helloWorldService", HelloWorldService.class);
        helloWorldService.sayAfterReturning();
    }

    @Test
    public void testSchemaAfterThrowingAdvice() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/chapter6/after-throwing.xml");
        HelloWorldService helloWorldService = ctx.getBean("helloWorldService", HelloWorldService.class);
        helloWorldService.sayAfterThrowing();
    }

    @Test
    public void testSchemaAfterFinallyAdvice() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/chapter6/after-finally.xml");
        HelloWorldService helloWorldService = ctx.getBean("helloWorldService", HelloWorldService.class);
        helloWorldService.sayAfterFinally();
    }

    @Test
    public void testSchemaAroundAdvice() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/chapter6/around.xml");
        HelloWorldService helloWorldService = ctx.getBean("helloWorldService", HelloWorldService.class);
        helloWorldService.sayAround("Fuck");
    }

    @Test
    public void testSchemaIntroduction() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/chapter6/induct.xml");
        IntroductionService helloWorldService = ctx.getBean("helloWorldService", IntroductionService.class);
        helloWorldService.induct();
    }

    @Test
    public void testSchemaAdvisor() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/chapter6/advice-before.xml");
        HelloWorldService helloWorldService = ctx.getBean("helloWorldService", HelloWorldService.class);
        helloWorldService.sayAdviceBefore("Good evening");
    }
}
