/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: SpELBean.java
 * Author:   Cheng Zhujiang
 * Date:     2017/8/13 17:09
 * Description: 
 */
package com.jemmy.spring.chapter5;

import org.springframework.beans.factory.annotation.Value;

/**
 * SpELBean
 *
 * @author Cheng Zhujiang
 * @date 2017/8/13
 */
public class SpELBean {

    @Value("#{'Hello' + world}")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
