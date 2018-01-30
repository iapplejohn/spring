/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: MoreDependencyInjectTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/17 9:27
 * Description: 
 */
package com.jemmy.spring.chapter3;

import com.jemmy.spring.chapter3.bean.DependentBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * MoreDependencyInjectTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/17
 */
public class MoreDependencyInjectTest {

    @Test
    public void testDependOn() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/chapter3/depends-on.xml");

        context.registerShutdownHook();
        DependentBean dependentBean = context.getBean("dependentBean", DependentBean.class);
        dependentBean.write("iloveyou");

    }
}
