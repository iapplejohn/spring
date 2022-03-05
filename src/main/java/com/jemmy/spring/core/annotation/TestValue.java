package com.jemmy.spring.core.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Value 默认值设置
 *
 * @author zhujiang.cheng
 * @since 2021/2/1
 */
@Component
public class TestValue {

    /**
     * 设置默认值为空字符串
     */
    @Value("${test.empty:533}")
    private String defaultEmpty;

    /**
     * 设置默认值为 null
     */
    @Value("${test.null:#{null}}")
    private String defaultNull;
}
