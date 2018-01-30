/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: JavaBean.java
 * Author:   Cheng Zhujiang
 * Date:     2017/6/27 9:24
 * Description: 
 */
package com.jemmy.spring.core.beanload;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * JavaBean
 *
 * @author Cheng Zhujiang
 * @date 2017/6/27
 */

public class JavaBean implements InitializingBean, DisposableBean, BeanFactoryAware, BeanPostProcessor, BeanFactoryPostProcessor {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("JavaBean类setName 方法");
        this.name = name;
    }

    public JavaBean() {
        System.out.println("JavaBean类构造方法");
    }

    public void init() throws Exception {
        System.out.println("JavaBean类init 方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware 接口 setBeanFactory方法");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor 接口 postProcessBeanFactory 方法");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+":BeanPostProcessor 接口 postProcessAfterInitialization方法");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName+":BeanPostProcessor 接口 postProcessBeforeInitialization 方法");
        return bean;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean 接口 destroy方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean 接口 afterPropertiesSet方法");
    }
}
