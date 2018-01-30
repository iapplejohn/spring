/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: BeanDefinition.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 15:53
 * Description: 
 */
package com.jemmy.spring.chapter3;

/**
 * BeanDefinition
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
public class BeanDefinition {

    //单例
    public static final int SCOPE_SINGLETON = 0;
    //原型
    public static final int SCOPE_PROTOTYPE = 1;
    //唯一标识
    private String id;
    //class全限定名
    private String clazz;
    //作用域
    private int scope = SCOPE_SINGLETON;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }
}
