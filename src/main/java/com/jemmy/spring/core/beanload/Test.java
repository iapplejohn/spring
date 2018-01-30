/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: Test.java
 * Author:   Cheng Zhujiang
 * Date:     2017/6/27 22:02
 * Description: 
 */
package com.jemmy.spring.core.beanload;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Test
 *
 * @author Cheng Zhujiang
 * @date 2017/6/27
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("加载Spring配置文件");
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring/core/beanload/beans.xml");
        System.out.println("加载Spring配置文件结束");
        JavaBean bean=(JavaBean)context.getBean("javaBean");
        System.out.println("获取name属性："+bean.getName());
        System.out.println("程序结束");
    }

}
