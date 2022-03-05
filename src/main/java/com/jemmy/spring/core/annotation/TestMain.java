package com.jemmy.spring.core.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhujiang.cheng
 * @since 2021/2/1
 */
public class TestMain {

    public static void main2(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TestValue.class);
        TestValue testValue = ctx.getBean(TestValue.class);
        System.out.println(testValue);
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/core/annotation/value-test.xml");
        TestValue testValue = ctx.getBean(TestValue.class);
        System.out.println(testValue);
    }
}