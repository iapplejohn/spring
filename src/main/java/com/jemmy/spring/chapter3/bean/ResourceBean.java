/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: ResourceBean.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/17 9:17
 * Description: 
 */
package com.jemmy.spring.chapter3.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ResourceBean
 *
 * @author Cheng Zhujiang
 * @date 2017/7/17
 */
public class ResourceBean {

    private FileOutputStream fos;

    private File file;

    public void init() {
        System.out.println("ResourceBean:========初始化");
        //加载资源,在此只是演示
        System.out.println("ResourceBean:========加载资源，执行一些预操作");
        try {
            this.fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        System.out.println("ResourceBean:========销毁");
        //释放资源
        System.out.println("ResourceBean:========释放资源，执行一些清理操作");
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileOutputStream getFos() {
        return fos;
    }
}
