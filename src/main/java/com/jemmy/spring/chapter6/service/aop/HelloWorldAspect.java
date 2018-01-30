/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HelloWorldAspect.java
 * Author:   Cheng Zhujiang
 * Date:     2017/5/7 14:42
 * Description: 
 */
package com.jemmy.spring.chapter6.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * HelloWorldAspect
 *
 * @author Cheng Zhujiang
 * @date 2017/5/7
 */
public class HelloWorldAspect {

    // =================== Chapter 6.2 ===============
    //前置通知
    public void beforeAdvice() {
        System.out.println("===========before advice");
    }

    //后置最终通知
    public void afterFinallyAdvice() {
        System.out.println("===========after finally advice");
    }

    // =================== Chapter 6.3 ===============
    public void beforeAdvice(String param) {
        System.out.println("===========before advice param:" + param);
    }

    public void afterReturningAdvice(Object retVal) {
        System.out.println("===========after returning advice retVal:" + retVal);
    }

    public void afterThrowingAdvice(Exception exception) {
        System.out.println("===========after throwing advice exception:" + exception);
    }

    public void afterFinallyAdvice2() {
        System.out.println("===========after finally advice2");
    }

    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("===========around before advice");
        Object retVal = pjp.proceed(new Object[] { "I love" } );
        System.out.println("===========around after advice");
        return retVal;
    }

}
