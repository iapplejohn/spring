/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: BeanDefinitionTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 16:38
 * Description: 
 */
package com.jemmy.spring.chapter3;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BeanDefinitionTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
public class CircleTest {

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleByConstructor() throws Throwable {
        try {
            new ClassPathXmlApplicationContext("spring/chapter3/circleInjectByConstructor.xml");
        } catch (Exception e) {
            //因为要在创建circle3时抛出；
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleBySetterAndPrototype() throws Throwable {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                    "spring/chapter3/circleInjectBySetterAndPrototype.xml");
            System.out.println(ctx.getBean("circleA"));
        }
        catch (Exception e) {
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleBySetterAndSingleton() throws Throwable {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
            ctx.setConfigLocation("spring/chapter3/circleInjectBySetterAndSingleton.xml");
            ctx.setAllowCircularReferences(false);
            ctx.refresh();
            System.out.println(ctx.getBean("circleA"));
        }
        catch (Exception e) {
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

}
