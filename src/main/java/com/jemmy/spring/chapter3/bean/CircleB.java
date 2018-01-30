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
public class CircleB {

    private CircleC circleC;

//    public CircleB(CircleC circleC) {
//        this.circleC = circleC;
//    }

    public void setCircleC(CircleC circleC) {
        this.circleC = circleC;
    }

    public void b() {
        circleC.c();
    }
}
