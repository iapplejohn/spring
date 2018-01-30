/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: Person.java
 * Author:   Cheng Zhujiang
 * Date:     2017/5/25 21:48
 * Description: 
 */
package com.jemmy.spring.core.autowire;

/**
 * Person
 *
 * @author Cheng Zhujiang
 * @date 2017/5/25
 */
public class Person {

    private Book book;

    public Person(Book book) {
        this.book = book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "I'm  a person  I want  to  read  a book " + book;
    }

    public Person() {
    }
}
