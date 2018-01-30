/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: SimplePostProcessor.java
 * Author:   Cheng Zhujiang
 * Date:     2017/6/12 23:03
 * Description: 
 */
package com.jemmy.spring.deeper.ch06;

/**
 * SimplePostProcessor
 *
 * @author Cheng Zhujiang
 * @date 2017/6/12
 */
public class SimplePostProcessor {

    private String connectionString;

    private String username;

    private String password;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SimplePostProcessor{" +
                "connectionString='" + connectionString + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
