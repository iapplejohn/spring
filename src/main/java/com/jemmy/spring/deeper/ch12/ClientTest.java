/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: ClientTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/12 16:23
 * Description: 
 */
package com.jemmy.spring.deeper.ch12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClientTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/12
 */
public class ClientTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/deeper/ch12/RMIClient.xml");
        HelloRMIService helloRMIService = ctx.getBean("myClient", HelloRMIService.class);
        System.out.println(helloRMIService.getAdd(3, 8));
    }
}
