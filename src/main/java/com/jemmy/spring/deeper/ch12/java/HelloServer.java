/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HelloServer.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/12 17:41
 * Description: 
 */
package com.jemmy.spring.deeper.ch12.java;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * HelloServer
 *
 * @author Cheng Zhujiang
 * @date 2017/7/12
 */
public class HelloServer {

    public static void main(String[] args) {
        try {
            //创建一个远程对象
            HelloService helloService = new HelloServiceImpl();

            //生成远程对象注册表Registry的实例，并指定端口为8888（默认端口是1099）
            LocateRegistry.createRegistry(8888);

            //把远程对象注册到RMI注册服务器上，并命名为RHello
            //绑定的URL标准格式为：rmi://host:port/name(协议名可以省略，下面两种写法都可以）
            Naming.bind("rmi://127.0.0.1:8888/HelloService", helloService);
            System.out.println(">>INFO:远程IHello对象绑定成功！");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

}
