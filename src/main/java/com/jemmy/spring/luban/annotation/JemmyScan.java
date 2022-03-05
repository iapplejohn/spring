package com.jemmy.spring.luban.annotation;

import com.jemmy.spring.luban.JemmyBeanDefinitionRegistrar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.context.annotation.Import;

/**
 * @author zhujiang.cheng
 * @since 2020/6/7
 */
@Import(JemmyBeanDefinitionRegistrar.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface JemmyScan {

    String[] value() default {};

}
