/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: ComponentScanTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/9/16 21:46
 * Description: 
 */
package com.jemmy.spring.core.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * ComponentScanTest
 *
 * @author Cheng Zhujiang
 * @date 2017/9/16
 */
public class ComponentScanTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/core/context/component-scan-test.xml");
        //MyController myController = context.getBean("myController", MyController.class);
        MyService myService = context.getBean("myService", MyService.class);
    }
}
