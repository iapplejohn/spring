/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: TestService.java
 * Author:   Cheng Zhujiang
 * Date:     2017/6/15 14:14
 * Description: 
 */
package com.jemmy.spring.deeper.ch07;

/**
 * TestService
 *
 * @author Cheng Zhujiang
 * @date 2017/6/15
 */
public class TestService {

    private String strTest;

    public void setStrTest(String strTest) {
        this.strTest = strTest;
    }

    public void test() {
        System.out.println("test");
    }
}
