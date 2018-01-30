/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: TestBeanTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/9/16 16:12
 * Description: 
 */
package com.jemmy.spring.core.beanload;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * TestBeanTest
 *
 * @author Cheng Zhujiang
 * @date 2017/9/16
 */
public class TestBeanTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/core/beanload/bean-test.xml");
        TestBean bean = context.getBean("testBean", TestBean.class);
        System.out.println(bean);
    }
}
