/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: AutowireBeanTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/22 10:58
 * Description: 
 */
package com.jemmy.spring.chapter3;

import com.jemmy.spring.chapter2.helloworld.HelloApi;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * AutowireBeanTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/22
 */
public class AutowireBeanTest {

    @Test
    public void testAutowireByName() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/chapter3/autowire-byName.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }

    @Test
    public void testAutowireByType1() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/chapter3/autowire-byType1.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }

    @Test
    public void testAutowireByType2() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/chapter3/autowire-byType2.xml");
        HelloApi helloApi = context.getBean("bean1", HelloApi.class);
        helloApi.sayHello();
    }

    @Test
    public void testAutowireByType3() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/chapter3/autowire-byType3.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }

    @Test
    public void testAutowireByConstructor() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/chapter3/autowire-byConstructor.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }

    @Test
    public void testAutowireAutoDetect() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/chapter3/autowire-autodetect.xml");
        HelloApi helloApi = context.getBean("bean", HelloApi.class);
        helloApi.sayHello();
    }
}
