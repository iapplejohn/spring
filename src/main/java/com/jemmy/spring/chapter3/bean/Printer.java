/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: Printer.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/22 15:34
 * Description: 
 */
package com.jemmy.spring.chapter3.bean;

/**
 * Printer
 *
 * @author Cheng Zhujiang
 * @date 2017/7/22
 */
public class Printer {

    private int counter = 0;

    public void print(String type) {
        System.out.println(type + " printer: " + counter++);
    }

}
