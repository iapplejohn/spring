/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: DependencyInjectTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 21:24
 * Description: 
 */
package com.jemmy.spring.chapter3;

import com.jemmy.spring.chapter2.helloworld.HelloApi;
import com.jemmy.spring.chapter3.bean.*;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * DependencyInjectTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
public class DependencyInjectTest {

    @Test
    public void testConstructorDependencyInjectTest() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring/chapter3/constructorDependencyInject.xml");

        //获取根据参数索引依赖注入的Bean
        HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
        byIndex.sayHello();
        //获取根据参数类型依赖注入的Bean
        HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
        byType.sayHello();
        //获取根据参数名字依赖注入的Bean
        HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
        byName.sayHello();
    }

    @Test
    public void testStaticFactoryDependencyInjectTest() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring/chapter3/staticFactoryDependencyInject.xml");

        //获取根据参数索引依赖注入的Bean
        HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
        byIndex.sayHello();
        //获取根据参数类型依赖注入的Bean
        HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
        byType.sayHello();
        //获取根据参数名字依赖注入的Bean
        HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
        byName.sayHello();
    }

    @Test
    public void testInstanceFactoryDependencyInjectTest() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring/chapter3/instanceFactoryDependencyInject.xml");

        //获取根据参数索引依赖注入的Bean
        HelloApi byIndex = beanFactory.getBean("byIndex", HelloApi.class);
        byIndex.sayHello();
        //获取根据参数类型依赖注入的Bean
        HelloApi byType = beanFactory.getBean("byType", HelloApi.class);
        byType.sayHello();
        //获取根据参数名字依赖注入的Bean
        HelloApi byName = beanFactory.getBean("byName", HelloApi.class);
        byName.sayHello();
    }

    @Test
    public void testSetterDependencyInjectTest() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring/chapter3/setterDependencyInject.xml");

        HelloApi bean = beanFactory.getBean("bean", HelloApi.class);
        bean.sayHello();
    }

    @Test
    public void testBooleanInjectTest() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring/chapter3/booleanInject.xml");

        BooleanTestBean bean1 = beanFactory.getBean("bean1", BooleanTestBean.class);
        System.out.println(bean1.toString());

        BooleanTestBean bean2 = beanFactory.getBean("bean2", BooleanTestBean.class);
        System.out.println(bean2.toString());

        BooleanTestBean bean3 = beanFactory.getBean("bean3", BooleanTestBean.class);
        System.out.println(bean3.toString());

        BooleanTestBean bean4 = beanFactory.getBean("bean4", BooleanTestBean.class);
        System.out.println(bean4.toString());
    }

}
