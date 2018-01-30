/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HelloMessage.java
 * Author:   Cheng Zhujiang
 * Date:     2017/6/12 21:58
 * Description: 
 */
package com.jemmy.spring.deeper.ch06;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * HelloMessage
 *
 * @author Cheng Zhujiang
 * @date 2017/6/12
 */
public class HelloMessage {

    private String mes;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/deeper/ch06/property-place-holder.xml");
        HelloMessage helloMessage = ctx.getBean("helloMessage", HelloMessage.class);
        String mes = helloMessage.getMes();
        System.out.println(mes);
    }

}
