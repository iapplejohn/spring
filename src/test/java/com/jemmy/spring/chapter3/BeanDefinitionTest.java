/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: BeanDefinitionTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 16:38
 * Description: 
 */
package com.jemmy.spring.chapter3;

import com.jemmy.spring.chapter3.BeanDefinition;
import com.jemmy.spring.chapter3.DefaultBeanFactory;
import com.jemmy.spring.chapter3.HelloImpl2;
import org.junit.Test;

/**
 * BeanDefinitionTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
public class BeanDefinitionTest {

    @Test
    public void testPrototype() throws Exception {
        DefaultBeanFactory bf = new DefaultBeanFactory();

        BeanDefinition bd = new BeanDefinition();
        bd.setId("bean");
        bd.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        bd.setClazz(HelloImpl2.class.getName());
        bf.registerBeanDefinition(bd);
        System.out.println(bf.getBean("bean") != bf.getBean("bean"));
    }

}
