/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HelloImpl3.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 21:17
 * Description: 
 */
package com.jemmy.spring.chapter3.helloworld;

import com.jemmy.spring.chapter2.helloworld.HelloApi;

/**
 * HelloImpl3
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
public class HelloImpl3 implements HelloApi {

    private String message;
    private int index;

    //@ConstructorProperties({ "message", "index" })
    public HelloImpl3(String message, int index) {
        this.message = message;
        this.index = index;
    }

    @Override
    public void sayHello() {
        System.out.println(index + ":" + message);
    }

}
