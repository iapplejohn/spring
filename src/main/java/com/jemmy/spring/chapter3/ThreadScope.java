/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: ThreadScope.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/16 17:00
 * Description: 
 */
package com.jemmy.spring.chapter3;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * ThreadScope
 *
 * @author Cheng Zhujiang
 * @date 2017/7/16
 */
public class ThreadScope implements Scope {

    private final ThreadLocal<Map<String, Object>> THREAD_SCOPE = new ThreadLocal<Map<String, Object>>() {

        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        //如果当前线程已经绑定了相应Bean，直接返回
        if (THREAD_SCOPE.get().containsKey(name)) {
            return THREAD_SCOPE.get().get(name);
        }
        //使用objectFactory创建Bean并绑定到当前线程上
        THREAD_SCOPE.get().put(name, objectFactory.getObject());
        return THREAD_SCOPE.get().get(name);
    }

    @Override
    public Object remove(String name) {
        return THREAD_SCOPE.get().remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        //此处不实现就代表类似proytotype，容器返回给用户后就不管了
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
