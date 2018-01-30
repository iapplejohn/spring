/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HttpInvokerClientTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/24 14:28
 * Description: 
 */
package com.jemmy.spring.deeper.ch12;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * HttpInvokerClientTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/24
 */
public class HttpInvokerClientTest {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring/deeper/ch12/client.xml");
        HttpInvokerTestI remoteService = context.getBean("remoteService", HttpInvokerTestI.class);
        String testPo = remoteService.getTestPo("Tina");
        System.out.println(testPo);
    }

}
