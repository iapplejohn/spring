/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HelloImpl.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 17:23
 * Description: 
 */
package com.jemmy.spring.chapter2.helloworld;

/**
 * HelloImpl
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
public class HelloImpl implements HelloApi {
    @Override
    public void sayHello() {
        System.out.println("Hello Tina");
    }
}
