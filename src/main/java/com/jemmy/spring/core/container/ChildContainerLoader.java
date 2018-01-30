/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: SubContainerLoader.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/3 19:35
 * Description: 
 */
package com.jemmy.spring.core.container;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ChildContainerLoader
 *
 * @author Cheng Zhujiang
 * @date 2017/7/3
 */
public class ChildContainerLoader implements ApplicationContextAware {

    ApplicationContext parentApplicationContext;

    ConfigurableApplicationContext childContext;

    public void load() {
        childContext = new ClassPathXmlApplicationContext("classpath:spring/container/plugin_*.xml");
        childContext.setParent(parentApplicationContext);
        childContext.refresh();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.parentApplicationContext = applicationContext;
    }

}
