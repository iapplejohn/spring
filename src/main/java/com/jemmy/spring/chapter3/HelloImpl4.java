/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HelloImpl4.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 22:46
 * Description: 
 */
package com.jemmy.spring.chapter3;

import com.jemmy.spring.chapter2.helloworld.HelloApi;

/**
 * HelloImpl4
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
public class HelloImpl4 implements HelloApi {

    private String message;
    private int index;

    @Override
    public void sayHello() {
        System.out.println(index + ":" + message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
