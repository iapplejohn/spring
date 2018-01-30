/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: ObscenityRemovingBeanFactoryPostProcessor.java
 * Author:   Cheng Zhujiang
 * Date:     2017/6/12 22:46
 * Description: 
 */
package com.jemmy.spring.deeper.ch06;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

/**
 * ObscenityRemovingBeanFactoryPostProcessor
 *
 * @author Cheng Zhujiang
 * @date 2017/6/12
 */
public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private Set<String> obscenities;

    public ObscenityRemovingBeanFactoryPostProcessor() {
        this.obscenities = new HashSet<>();
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
            StringValueResolver valueResolver = strVal -> {
                if (isObscene(strVal)) {
                    return "*****";
                }
                return strVal;
            };

            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
            visitor.visitBeanDefinition(bd);
        }
    }

    private boolean isObscene(String strVal) {
        String potentialObscenity = strVal.toUpperCase();
        return this.obscenities.contains(potentialObscenity);
    }

    public void setObscenities(Set<String> obscenities) {
        this.obscenities.clear();
        for (String obscenity : obscenities) {
            this.obscenities.add(obscenity.toUpperCase());
        }
    }
}
