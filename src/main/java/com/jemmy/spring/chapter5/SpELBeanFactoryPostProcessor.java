/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: SpELBeanFactoryPostProcessor.java
 * Author:   Cheng Zhujiang
 * Date:     2017/8/13 17:24
 * Description: 
 */
package com.jemmy.spring.chapter5;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanExpressionResolver;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.expression.StandardBeanExpressionResolver;

/**
 * SpELBeanFactoryPostProcessor
 *
 * @author Cheng Zhujiang
 * @date 2017/8/13
 */
public class SpELBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        StandardBeanExpressionResolver resolver = (StandardBeanExpressionResolver) beanFactory.getBeanExpressionResolver();
        resolver.setExpressionPrefix("%{");
        resolver.setExpressionSuffix("}");
    }
}
