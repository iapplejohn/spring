/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: MyService.java
 * Author:   Cheng Zhujiang
 * Date:     2017/9/16 21:45
 * Description: 
 */
package com.jemmy.spring.core.context;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * MyService
 *
 * @author Cheng Zhujiang
 * @date 2017/9/16
 */
@Service
public class MyService implements InitializingBean {

    @Value("${testvalue:abc:https://www.jemmy.com}")
    private String test;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(test);
    }
}
