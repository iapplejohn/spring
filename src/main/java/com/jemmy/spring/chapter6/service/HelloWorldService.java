/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HelloWorldService.java
 * Author:   Cheng Zhujiang
 * Date:     2017/5/7 14:34
 * Description: 
 */
package com.jemmy.spring.chapter6.service;

/**
 * HelloWorldService
 *
 * @author Cheng Zhujiang
 * @date 2017/5/7
 */
public interface HelloWorldService {

    // Chapter 6.3
    void sayBefore(String param);

    // Chapter 6.2
    void sayHello();

    // Chapter 6.3
    boolean sayAfterReturning();

    void sayAfterThrowing();

    boolean sayAfterFinally();

    void sayAround(String param);

    // Chapter 6.3.5
    void sayAdviceBefore(String param);
}
