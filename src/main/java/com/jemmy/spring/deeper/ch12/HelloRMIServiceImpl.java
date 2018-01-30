/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HelloRMIServiceImpl.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/12 16:01
 * Description: 
 */
package com.jemmy.spring.deeper.ch12;

/**
 * HelloRMIServiceImpl
 *
 * @author Cheng Zhujiang
 * @date 2017/7/12
 */
public class HelloRMIServiceImpl implements HelloRMIService {

    @Override
    public int getAdd(int a, int b) {
        return a + b;
    }
}
