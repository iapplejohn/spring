/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: PropertyConfigurerDemo.java
 * Author:   Cheng Zhujiang
 * Date:     2017/6/12 22:57
 * Description: 
 */
package com.jemmy.spring.deeper.ch06;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * PropertyConfigurerDemo
 *
 * @author Cheng Zhujiang
 * @date 2017/6/12
 */
public class PropertyConfigurerDemo {

    public static void main(String[] args) {
        ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring/deeper/ch06/beanFactory.xml"));
        BeanFactoryPostProcessor bfpp = beanFactory.getBean("bfpp", BeanFactoryPostProcessor.class);
        bfpp.postProcessBeanFactory(beanFactory);
        System.out.println(beanFactory.getBean("simpleBean"));
    }

}
