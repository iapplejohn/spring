/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: User.java
 * Author:   Cheng Zhujiang
 * Date:     2017/6/27 9:23
 * Description: 
 */
package com.jemmy.spring.core.beanload;

/**
 * User
 *
 * @author Cheng Zhujiang
 * @date 2017/6/27
 */
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("User类 setName方法");
        this.name = name;
    }

    public void init() throws Exception {
        System.out.println("User类init 方法");

    }

    public User() {
        System.out.println("User类构造方法");
    }

}
