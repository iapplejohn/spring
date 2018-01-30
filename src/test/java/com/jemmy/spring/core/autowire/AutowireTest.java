/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: AutowireTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/5/25 22:38
 * Description: 
 */
package com.jemmy.spring.core.autowire;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AutowireTest
 *
 * @author Cheng Zhujiang
 * @date 2017/5/25
 */
public class AutowireTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/core/autowire/auto-wire.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person.toString());
    }

}
