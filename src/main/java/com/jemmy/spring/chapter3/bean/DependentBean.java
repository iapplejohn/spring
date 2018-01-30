/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: DependentBean.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/17 9:19
 * Description: 
 */
package com.jemmy.spring.chapter3.bean;

import java.io.IOException;

/**
 * DependentBean
 *
 * @author Cheng Zhujiang
 * @date 2017/7/17
 */
public class DependentBean {

    ResourceBean resourceBean;

    public void write(String str) throws IOException {
        System.out.println("DependentBean:=======写资源");
        resourceBean.getFos().write(str.getBytes());
    }

    //初始化方法
    public void init() throws IOException {
        System.out.println("DependentBean:=======初始化");
        resourceBean.getFos().write("DependentBean:=======初始化=====".getBytes());
    }

    //销毁方法
    public void destroy() throws IOException {
        System.out.println("DependentBean:=======销毁");
        //在销毁之前需要往文件中写销毁内容
        resourceBean.getFos().write("DependentBean:=======销毁=====".getBytes());
    }

    public void setResourceBean(ResourceBean resourceBean) {
        this.resourceBean = resourceBean;
    }
}
