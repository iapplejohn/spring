/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: SpELUseTest2.java
 * Author:   Cheng Zhujiang
 * Date:     2017/8/10 9:15
 * Description: 
 */
package com.jemmy.spring.chapter5;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

/**
 * SpELUseTest
 *
 * @author Cheng Zhujiang
 * @date 2017/8/10
 */
public class SpELUseTest {

    @Test
    public void testXmlExpression() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/chapter5/el1.xml");
        String hello1 = ctx.getBean("hello1", String.class);
        String hello2 = ctx.getBean("hello2", String.class);
        String hello3 = ctx.getBean("hello3", String.class);

        Assert.assertEquals("Hello World!", hello1);
        Assert.assertEquals("Hello World!", hello2);
        Assert.assertEquals("Hello World!", hello3);
    }

    @Test
    public void testAnnotationExpression() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/chapter5/el2.xml");
        SpELBean helloBean1 = ctx.getBean("helloBean1", SpELBean.class);
        Assert.assertEquals("Hello World!", helloBean1.getValue());
        SpELBean helloBean2 = ctx.getBean("helloBean2", SpELBean.class);
        Assert.assertEquals("Fabulous", helloBean2.getValue());
    }

    @Test
    public void testPrefixExpression() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/chapter5/el3.xml");
        SpELBean helloBean1 = ctx.getBean("helloBean1", SpELBean.class);
        Assert.assertEquals("#{'Hello' + world}", helloBean1.getValue());
        SpELBean helloBean2 = ctx.getBean("helloBean2", SpELBean.class);
        Assert.assertEquals("Hello World!", helloBean2.getValue());
    }

}
