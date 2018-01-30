/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: BeanDefinitionRegister.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 15:54
 * Description: 
 */
package com.jemmy.spring.chapter3;

import java.util.HashMap;
import java.util.Map;

/**
 * BeanDefinitionRegistry
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
public class BeanDefinitionRegistry {

    //bean定义缓存，此处不考虑并发问题
    private final Map<String, BeanDefinition> DEFINITIONS = new HashMap<>();

    public void registerBeanDefinition(String beanName, BeanDefinition bd) {
        //1.本实现不允许覆盖Bean定义
        if (DEFINITIONS.containsKey(beanName)) {
            throw new RuntimeException("已存在Bean定义，此实现不允许覆盖");
        }
        //2.将Bean定义放入Bean定义缓存池
        DEFINITIONS.put(bd.getId(), bd);
    }

    public BeanDefinition getBeanDefinition(String beanName) {
        return DEFINITIONS.get(beanName);
    }

    public boolean containsBeanDefinition(String beanName) {
        return DEFINITIONS.containsKey(beanName);
    }
}
