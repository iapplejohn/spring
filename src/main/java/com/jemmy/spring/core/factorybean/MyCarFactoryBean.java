/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: MyCarFactoryBean.java
 * Author:   Cheng Zhujiang
 * Date:     2017/5/25 19:28
 * Description: 
 */
package com.jemmy.spring.core.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * MyCarFactoryBean
 *
 * @author Cheng Zhujiang
 * @date 2017/5/25
 */
public class MyCarFactoryBean implements FactoryBean<Car> {

    private String make;

    private int year;

    public void setMake(String make) {
        this.make = make;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public Car getObject() throws Exception {
        //Here  is a complex  car  object  created
        // wouldn't be a very useful FactoryBean
        // if we could simply instantiate the object!
        Car car = new Car();
        if (year != 0) {
            car.setYear(year);
        }

        if ("make".equals(make)) {
            car.setMake("we are making bla bla bla");
        } else {
            car.setMake(this.make);
        }
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
