/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HelloService.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/12 17:34
 * Description: 
 */
package com.jemmy.spring.deeper.ch12.java;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 定义远程接口，必须继承Remote接口，
 * 其中所有需要远程调用的方法都必须抛出RemoteException异常
 *
 * @author Cheng Zhujiang
 * @date 2017/7/12
 */
public interface HelloService extends Remote {

    String sayHello(String name) throws RemoteException;

    int sum(int a, int b) throws RemoteException;

}
