/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: SingletonBeanRegister.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 15:35
 * Description: 
 */
package com.jemmy.spring.chapter3.bean;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * SingletonBeanRegister
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
public class SingletonBeanRegister implements SingletonBeanRegistry {

    private final Map<String, Object> BEANS = new HashMap<>();

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        if (BEANS.containsKey(beanName)) {
            throw new RuntimeException("[" + beanName + "] 已存在");
        }
        BEANS.put(beanName, singletonObject);
    }

    @Override
    public Object getSingleton(String beanName) {
        return BEANS.get(beanName);
    }

    @Override
    public boolean containsSingleton(String beanName) {
        return BEANS.containsKey(beanName);
    }

    @Override
    public String[] getSingletonNames() {
        Set<String> strings = BEANS.keySet();
        return strings.toArray(new String[strings.size()]);
    }

    @Override
    public int getSingletonCount() {
        return BEANS.size();
    }

    @Override
    public Object getSingletonMutex() {
        return SingletonBeanRegister.class;
    }
}
