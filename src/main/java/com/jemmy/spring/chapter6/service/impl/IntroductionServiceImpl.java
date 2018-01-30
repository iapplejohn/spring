/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: IntroductionServiceImpl.java
 * Author:   Cheng Zhujiang
 * Date:     2017/5/7 17:51
 * Description: 
 */
package com.jemmy.spring.chapter6.service.impl;

import com.jemmy.spring.chapter6.service.IntroductionService;

/**
 * IntroductionServiceImpl
 *
 * @author Cheng Zhujiang
 * @date 2017/5/7
 */
public class IntroductionServiceImpl implements IntroductionService {
    @Override
    public void induct() {
        System.out.println("=========introduction");
    }
}
