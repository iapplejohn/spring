/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HelloImpl5.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/22 15:36
 * Description: 
 */
package com.jemmy.spring.chapter3;

import com.jemmy.spring.chapter2.helloworld.HelloApi;
import com.jemmy.spring.chapter3.bean.Printer;

/**
 * HelloImpl5
 *
 * @author Cheng Zhujiang
 * @date 2017/7/22
 */
public abstract class HelloImpl5 implements HelloApi {

    private Printer printer;

    public void sayHello() {
        printer.print("setter");
        createPrototypePrinter().print("prototype");
        createSingletonPrinter().print("singleton");
    }

    protected abstract Printer createPrototypePrinter();

    public Printer createSingletonPrinter() {
        System.out.println("该方法不会被执行，如果输出就错了");
        return new Printer();
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
}
