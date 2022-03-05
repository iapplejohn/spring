package com.jemmy.spring.luban;

import com.jemmy.spring.luban.service.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhujiang.cheng
 * @since 2020/6/7
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = applicationContext.getBean("user", User.class);
        System.out.println("user: " + user);
    }
}
