/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: DependencyCheckTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/22 14:51
 * Description: 
 */
package com.jemmy.spring.chapter3;

import org.junit.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * DependencyCheckTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/22
 */
public class DependencyCheckTest {

    @Test(expected = UnsatisfiedDependencyException.class)
    public void testDependencyCheckByObject() throws IOException {
        //将抛出异常
        new ClassPathXmlApplicationContext("spring/chapter3/dependency-check-object.xml");
    }

    @Test(expected = UnsatisfiedDependencyException.class)
    public void testDependencyCheckBySimple() throws IOException {
        //将抛出异常
        new ClassPathXmlApplicationContext("spring/chapter3/dependency-check-simple.xml");
    }

    public void testDependencyCheckByAll() throws IOException {
        //将抛出异常
        new ClassPathXmlApplicationContext("spring/chapter3/dependency-check-all.xml");
    }
}
