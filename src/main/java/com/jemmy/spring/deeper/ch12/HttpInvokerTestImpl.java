/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HttpInvokerTestImpl.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/24 14:02
 * Description: 
 */
package com.jemmy.spring.deeper.ch12;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

/**
 * HttpInvokerTestImpl
 *
 * @author Cheng Zhujiang
 * @date 2017/7/24
 */
public class HttpInvokerTestImpl implements HttpInvokerTestI, InitializingBean, BeanFactoryAware {
    @Override
    public String getTestPo(String desp) {
        return "getTestPo " + desp;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("do something");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        HttpInvokerServiceExporter exporter = beanFactory.getBean("/hit", HttpInvokerServiceExporter.class);
    }
}
