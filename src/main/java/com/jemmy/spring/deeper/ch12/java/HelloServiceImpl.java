/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HelloServiceImpl.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/12 17:35
 * Description: 
 */
package com.jemmy.spring.deeper.ch12.java;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * http://blog.csdn.net/zmx729618/article/details/52130722
 *
 * @author Cheng Zhujiang
 * @date 2017/7/12
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    private static final long serialVersionUID = 1961558474342609777L;

    // 因为构造方法需要抛出RemoteException，
    // 所以不能缺省使用隐含的无参构造方法，而应该自己显式定义构造方法
    protected HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello, " + name;
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }
}
