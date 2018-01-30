/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: ScopeTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/9/16 17:54
 * Description: 
 */
package com.jemmy.spring.core.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * ScopeTest
 *
 * @author Cheng Zhujiang
 * @date 2017/9/16
 */
public class ScopeTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/core/scope/scope-test.xml");
        SingletonBean singleton1 = context.getBean(SingletonBean.class);
        SingletonBean singleton2 = context.getBean(SingletonBean.class);
        System.out.println(singleton1 == singleton2);

        PrototypeBean prototype1 = context.getBean(PrototypeBean.class);
        PrototypeBean prototype2 = context.getBean(PrototypeBean.class);
        System.out.println(prototype1 == prototype2);
    }
}
