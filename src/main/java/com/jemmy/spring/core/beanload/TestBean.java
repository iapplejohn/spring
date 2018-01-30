/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: TestBean.java
 * Author:   Cheng Zhujiang
 * Date:     2017/9/16 16:10
 * Description: 
 */
package com.jemmy.spring.core.beanload;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * TestBean
 *
 * @author Cheng Zhujiang
 * @date 2017/9/16
 */
@Component
public class TestBean implements BeanNameAware {

    private String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
