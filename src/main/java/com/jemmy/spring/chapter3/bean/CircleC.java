/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: CircleB.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 23:10
 * Description: 
 */
package com.jemmy.spring.chapter3.bean;

/**
 * CircleB
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
public class CircleC {

    private CircleA circleA;

//    public CircleC(CircleA circleA) {
//        this.circleA = circleA;
//    }

    public void setCircleA(CircleA circleA) {
        this.circleA = circleA;
    }

    public void c() {
        circleA.a();
    }
}
