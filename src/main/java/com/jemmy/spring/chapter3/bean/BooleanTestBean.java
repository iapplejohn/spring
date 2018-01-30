/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: BooleanTestBean.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 22:52
 * Description: 
 */
package com.jemmy.spring.chapter3.bean;

/**
 * BooleanTestBean
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
public class BooleanTestBean {

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "BooleanTestBean{" +
                "success=" + success +
                '}';
    }
}
