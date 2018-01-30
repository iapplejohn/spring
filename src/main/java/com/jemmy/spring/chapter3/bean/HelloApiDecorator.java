/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HelloApiDecorator.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/22 10:55
 * Description: 
 */
package com.jemmy.spring.chapter3.bean;

import com.jemmy.spring.chapter2.helloworld.HelloApi;

/**
 * HelloApiDecorator
 *
 * @author Cheng Zhujiang
 * @date 2017/7/22
 */
public class HelloApiDecorator implements HelloApi {

    private HelloApi helloApi;
    private String message;

    public HelloApiDecorator() {

    }

    public HelloApiDecorator(HelloApi helloApi) {
        this.helloApi = helloApi;
    }

    public HelloApi getHelloApi() {
        return helloApi;
    }

    public void setHelloApi(HelloApi helloApi) {
        this.helloApi = helloApi;
    }

    @Override
    public void sayHello() {
        helloApi.sayHello();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
