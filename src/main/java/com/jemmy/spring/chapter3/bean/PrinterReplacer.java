/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: PrinterReplacer.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/22 16:38
 * Description: 
 */
package com.jemmy.spring.chapter3.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * PrinterReplacer
 *
 * @author Cheng Zhujiang
 * @date 2017/7/22
 */
public class PrinterReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("Print Replacer");
        //注意此处不能再通过反射调用了,否则会产生循环调用，知道内存溢出
        //method.invoke(obj, new String[]{"hehe"});
        return null;
    }
}
