/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: Person.java
 * Author:   Cheng Zhujiang
 * Date:     2017/5/25 19:32
 * Description: 
 */
package com.jemmy.spring.core.factorybean;

/**
 * Person
 *
 * @author Cheng Zhujiang
 * @date 2017/5/25
 */
public class Person {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return car.getMake() + "::::" + car.getYear();
    }
}
