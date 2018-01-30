/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: ServerTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/12 16:20
 * Description: 
 */
package com.jemmy.spring.deeper.ch12;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ServerTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/12
 */
public class ServerTest {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring/deeper/ch12/RMIServer.xml");
    }
}
