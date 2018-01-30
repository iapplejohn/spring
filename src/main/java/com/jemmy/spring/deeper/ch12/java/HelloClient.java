/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HelloClient.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/12 17:59
 * Description: 
 */
package com.jemmy.spring.deeper.ch12.java;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * HelloClient
 *
 * @author Cheng Zhujiang
 * @date 2017/7/12
 */
public class HelloClient {

    public static void main(String args[]) {
        HelloService helloService = null;
        try {
            helloService = (HelloService) Naming.lookup("rmi://127.0.0.1:8888/HelloService");
            System.out.println(helloService.sayHello("world"));
            System.out.println(helloService.sum(454, 5457));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}