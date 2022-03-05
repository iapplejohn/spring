package com.jemmy.spring.luban;

import com.jemmy.spring.luban.annotation.JemmyScan;
import com.jemmy.spring.luban.service.A;
import com.jemmy.spring.luban.service.B;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zhujiang.cheng
 * @since 2020/6/7
 */
@Configuration
@ComponentScan("com.jemmy")
@Import({A.class, B.class, JemmyBeanFactoryPostProcessor.class })
@JemmyScan("com.jemmy.spring.luban")
//@MapperScan("com.jemmy.spring.luban")
public class AppConfig {

}
