/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: ChildContainer1.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/3 19:46
 * Description: 
 */
package com.jemmy.spring.core.container;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

/**
 * ChildContext1
 *
 * @author Cheng Zhujiang
 * @date 2017/7/3
 */
public class ChildContext1 implements ApplicationContextAware {

    ApplicationContext parentApplicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext.getParent() == null) {
            return;
        }

        // 两级和多级的区别？
        this.parentApplicationContext = applicationContext.getParent(); //Get parent application context

        ConfigurableApplicationContext childContext = new ClassPathXmlApplicationContext("classpath:spring/container/child1.xml");
        childContext.setParent(this.parentApplicationContext);
        childContext.refresh();
        ParentClass parentClass = childContext.getBean(ParentClass.class);
        Assert.notNull(parentClass);

    }
}
