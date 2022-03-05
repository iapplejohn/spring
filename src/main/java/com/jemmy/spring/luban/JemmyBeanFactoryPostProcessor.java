package com.jemmy.spring.luban;

import com.jemmy.spring.luban.service.A;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author zhujiang.cheng
 * @since 2020/6/7
 */
@Component
public class JemmyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
        throws BeansException {

        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("user");
        System.out.println("beanDefinition = " + beanDefinition);

        beanFactory.getBean("user");
        beanDefinition.setBeanClass(A.class);
    }
}
