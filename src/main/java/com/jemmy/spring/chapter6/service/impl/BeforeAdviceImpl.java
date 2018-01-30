/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: BeforeAdviceImpl.java
 * Author:   Cheng Zhujiang
 * Date:     2017/5/7 18:14
 * Description: 
 */
package com.jemmy.spring.chapter6.service.impl;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * BeforeAdviceImpl
 *
 * @author Cheng Zhujiang
 * @date 2017/5/7
 */
public class BeforeAdviceImpl implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("===========before advice");
    }
}
