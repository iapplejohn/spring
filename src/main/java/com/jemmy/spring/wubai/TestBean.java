/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: TestBean.java
 * Author:   Cheng Zhujiang
 * Date:     2017/9/6 16:51
 * Description: 
 */
package com.jemmy.spring.wubai;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * TestBean
 *
 * @author Cheng Zhujiang
 * @date 2017/9/6
 */
public class TestBean implements BeanNameAware {

    private String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/wubai/test-bean-name-aware.xml");
        TestBean bean =  context.getBean(TestBean.class);
        System.out.println(bean.name);
    }

}
