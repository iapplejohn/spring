/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: DependencyInjectByInstanceFactory.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 22:36
 * Description: 
 */
package com.jemmy.spring.chapter3;

import com.jemmy.spring.chapter2.helloworld.HelloApi;
import com.jemmy.spring.chapter3.helloworld.HelloImpl3;

/**
 * 实例工厂类
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
public class DependencyInjectByInstanceFactory {

    public HelloApi newInstance(String message, int index) {
        return new HelloImpl3(message, index);
    }

}
