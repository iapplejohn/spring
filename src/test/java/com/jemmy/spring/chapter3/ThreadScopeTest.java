/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: ThreadScopeTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 17:24
 * Description: 
 */
package com.jemmy.spring.chapter3;

import com.jemmy.spring.chapter2.helloworld.HelloImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * ThreadScopeTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
@ContextConfiguration( locations = { "classpath:spring/chapter3/threadScope.xml" } )
@RunWith(SpringJUnit4ClassRunner.class)
public class ThreadScopeTest {

    @Resource
    ApplicationContext ctx;

    @Test
    public void inSingleThreadTest() {
        HelloImpl instance1 = ctx.getBean("helloApi", HelloImpl.class);
        HelloImpl instance2 = ctx.getBean("helloApi", HelloImpl.class);
        System.out.println(instance1 == instance2);
        Assert.assertTrue(instance1 == instance2);
    }

    @Test
    public void inDifferentThreadsTest() {
        HelloImpl instance1 = ctx.getBean("helloApi", HelloImpl.class);
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        HelloImpl instance2 = ctx.getBean("helloApi", HelloImpl.class);
                        System.out.println(instance1 == instance2);
                        Assert.assertTrue(instance1 == instance2);
                    }
                }
        ).start();

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
