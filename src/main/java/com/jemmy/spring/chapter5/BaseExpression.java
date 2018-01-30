/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: BaseExpression.java
 * Author:   Cheng Zhujiang
 * Date:     2017/8/2 9:20
 * Description: 
 */
package com.jemmy.spring.chapter5;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * BaseExpression
 *
 * @author Cheng Zhujiang
 * @date 2017/8/2
 */
public class BaseExpression {

    public static void main(String[] args) {
        // 一、字面量表达式
        // 字符串
        ExpressionParser parser = new SpelExpressionParser();
        String str1 = parser.parseExpression("'Hello World!'").getValue(String.class);
        String str2 = parser.parseExpression("\"Hello World!\"").getValue(String.class);
        System.out.println("str1=" + str1);
        System.out.println("str2=" + str2);

        // 数字类型
        int int1 = parser.parseExpression("1").getValue(Integer.class);
        long long1 = parser.parseExpression("-1L").getValue(long.class);
        float float1 = parser.parseExpression("1.1").getValue(Float.class);
        double double1 = parser.parseExpression("1.1E+2").getValue(double.class);
        int hex1 = parser.parseExpression("0xa").getValue(Integer.class);
        long hex2 = parser.parseExpression("0xaL").getValue(long.class);
        System.out.println("int1=" + int1);
        System.out.println("long1=" + long1);
        System.out.println("float1=" + float1);
        System.out.println("double1=" + double1);
        System.out.println("hex1=" + hex1);
        System.out.println("hex2=" + hex2);

        // 布尔类型
        boolean true1 = parser.parseExpression("true").getValue(boolean.class);
        boolean false1 = parser.parseExpression("false").getValue(boolean.class);
        System.out.println("true1=" + true1);
        System.out.println("false1=" + false1);

        // null类型
        Object null1 = parser.parseExpression("null").getValue(Object.class);
        System.out.println("null1=" + null1);

        // 二、算数运算表达式
        int result1 = parser.parseExpression("1+2-3*4/2").getValue(Integer.class); // -3
        int result2 = parser.parseExpression("4%3").getValue(Integer.class); // 1
        int result3 = parser.parseExpression("2^3").getValue(Integer.class); // 8
        System.out.println("result1=" + result1);
        System.out.println("result2=" + result2);
        System.out.println("result3=" + result3);

        // 三、关系表达式
        boolean bool1 = parser.parseExpression("1>2").getValue(boolean.class);
        boolean bool2 = parser.parseExpression("1 between {1, 2}").getValue(boolean.class);
        System.out.println("bool1=" + bool1);
        System.out.println("bool2=" + bool2);

        // 四、逻辑表达式
        String expression1 = "2>1 and (!true or !false)";
        boolean result4 = parser.parseExpression(expression1).getValue(boolean.class);
        System.out.println("result4=" + result4);
        String expression2 = "2>1 and (NOT true or NOT false)";
        boolean result5 = parser.parseExpression(expression2).getValue(boolean.class);
        System.out.println("result5=" + result5);

        // 五、字符串连接及截取表达式
        String str3 = parser.parseExpression("'Hello ' + 'World!'").getValue(String.class);
        String str4 = parser.parseExpression("'Hello World!'[0]").getValue(String.class);
        System.out.println("str3=" + str3);
        System.out.println("str4=" + str4);

        // 六、三目运算及Elivis运算表达式
        boolean bool3 = parser.parseExpression("null?:false").getValue(boolean.class);
        boolean bool4 = parser.parseExpression("true?:false").getValue(boolean.class);
        System.out.println("bool3=" + bool3);
        System.out.println("bool4=" + bool4);

        // 七、正则表达式
        boolean boolRegex = parser.parseExpression("'123' matches '\\d{3}'").getValue(boolean.class);
        System.out.println("boolRegex=" + boolRegex);

        // 八、括号优先级表达式 使用“(表达式)”构造，括号里的具有高优先级。

    }

}
