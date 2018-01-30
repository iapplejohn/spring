/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: ChildClass.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/3 19:53
 * Description: 
 */
package com.jemmy.spring.core.container;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ChildClass1
 *
 * @author Cheng Zhujiang
 * @date 2017/7/3
 */
public class ChildClass2 implements InitializingBean {

    //这里required加上false，是因为是没有建立父子容器关系之前，这个parentClass是注入不了了的
    @Autowired(required = false)
    ParentClass parentClass;

    //这里required加上false，是因为子容器之前是不能够相互引用的，只是测试使用。另注：这个类没有放到这里，在子容器2中，这里不贴代码了
    @Autowired(required = false)
    ChildClass1 childClass1;

    public void print() {
        if (parentClass != null) {
            parentClass.print();
        }
        System.out.println("This is child class 2");
        if (childClass1 != null) {
            childClass1.print();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        print();
    }
}
