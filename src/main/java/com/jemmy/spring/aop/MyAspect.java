package com.jemmy.spring.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author zhujiang.cheng
 * @since 2020/12/15
 */
@Aspect
public class MyAspect {

    @Pointcut("execution(* com.jemmy.spring.aop.TestService.*(..))")
    public void handleLog() {

    }

    @AfterReturning(pointcut = "handleLog()", returning = "ret")
    public void doAfterReturning(Object ret) {
        // 发送恢复通知
        System.out.println("send resume");
    }

}
