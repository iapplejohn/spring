package com.jemmy.spring.luban.service;

import com.jemmy.spring.luban.dao.OrderMapper;
import com.jemmy.spring.luban.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhujiang.cheng
 * @since 2020/6/7
 */
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    public void test() {
        userMapper.selectById();
        orderMapper.selectById();
    }
}
