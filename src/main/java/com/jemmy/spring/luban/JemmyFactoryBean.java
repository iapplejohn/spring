package com.jemmy.spring.luban;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author zhujiang.cheng
 * @since 2020/6/7
 */
public class JemmyFactoryBean implements FactoryBean {

    private Mapper mapper;

    public JemmyFactoryBean(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return Mapper.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
