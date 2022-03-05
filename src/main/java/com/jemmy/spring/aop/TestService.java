package com.jemmy.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhujiang.cheng
 * @since 2020/12/15
 */
public class TestService {

    void doSomething() {
        System.out.println("gorgeous");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/aop/aop.xml");
        TestService bean =  context.getBean(TestService.class);
        bean.doSomething();
    }
}
