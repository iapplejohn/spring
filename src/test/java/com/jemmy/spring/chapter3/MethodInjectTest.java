/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: MethodInjectTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/22 15:52
 * Description: 
 */
package com.jemmy.spring.chapter3;

import com.jemmy.spring.chapter2.helloworld.HelloApi;
import com.jemmy.spring.chapter3.bean.Printer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MethodInjectTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/22
 */
public class MethodInjectTest {

    @Test
    public void testLookup() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/chapter3/lookupMethodInject.xml");
        System.out.println("=======singleton sayHello======");
        HelloApi helloApi1 = context.getBean("helloApi1", HelloApi.class);
        helloApi1.sayHello();
        helloApi1 = context.getBean("helloApi1", HelloApi.class);
        helloApi1.sayHello();

        System.out.println("=======prototype sayHello======");
        HelloApi helloApi2 = context.getBean("helloApi2", HelloApi.class);
        helloApi2.sayHello();
        helloApi2 = context.getBean("helloApi2", HelloApi.class);
        helloApi2.sayHello();
    }

    @Test
    public void testMethodReplacer() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/chapter3/methodReplacerInject.xml");
        Printer printer = context.getBean("printer", Printer.class);
        printer.print("我将被替换");
    }

}