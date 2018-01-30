/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: InjectBeanFactoryTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/6/12 21:33
 * Description: 
 */
package com.jemmy.spring.deeper.ch06;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * InjectBeanFactoryTest
 *
 * @author Cheng Zhujiang
 * @date 2017/6/12
 */
public class InjectBeanFactoryTest {

    @Autowired
    BeanFactory beanFactory;

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/deeper/ch06/inject-bean-factory.xml");
        InjectBeanFactoryTest test = ctx.getBean("injectBeanFactoryTest", InjectBeanFactoryTest.class);
        BeanFactory bf = test.getBeanFactory();
        System.out.println(bf);
    }
}
