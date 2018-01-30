/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HelloWorldServiceImpl.java
 * Author:   Cheng Zhujiang
 * Date:     2017/5/7 14:35
 * Description: 
 */
package com.jemmy.spring.chapter6.service.impl;

import com.jemmy.spring.chapter6.service.HelloWorldService;

/**
 * HelloWorldServiceImpl
 *
 * @author Cheng Zhujiang
 * @date 2017/5/7
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public void sayBefore(String param) {
        System.out.println("============say " + param);
    }

    @Override
    public void sayHello() {
        System.out.println("============Hello World!");
    }

    @Override
    public boolean sayAfterReturning() {
        System.out.println("============after returning");
        return true;
    }

    @Override
    public void sayAfterThrowing() {
        System.out.println("============before throwing");
        throw new RuntimeException();
    }

    @Override
    public boolean sayAfterFinally() {
        System.out.println("============before finally");
        throw new RuntimeException("Yun");
    }

    @Override
    public void sayAround(String param) {
        System.out.println("============around param:" + param);
    }

    @Override
    public void sayAdviceBefore(String param) {
        System.out.println("============say " + param);
    }
}
