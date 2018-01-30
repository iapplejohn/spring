/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: ParentRunner.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/3 19:33
 * Description: 
 */
package com.jemmy.spring.core.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * ParentRunner
 *
 * @author Cheng Zhujiang
 * @date 2017/7/3
 */
public class ParentRunner {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/container/spring1.xml");

        TimeUnit.SECONDS.sleep(1000);
    }
}
