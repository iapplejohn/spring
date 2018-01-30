/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: CircleA.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 23:10
 * Description: 
 */
package com.jemmy.spring.chapter3.bean;

/**
 * CircleA
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
public class CircleA {

    private CircleB circleB;

//    public CircleA(CircleB circleB) {
//        this.circleB = circleB;
//    }

    public void setCircleB(CircleB circleB) {
        this.circleB = circleB;
    }

    public void a() {
        circleB.b();
    }
}
