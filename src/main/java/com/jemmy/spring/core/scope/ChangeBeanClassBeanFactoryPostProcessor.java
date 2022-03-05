package com.jemmy.spring.core.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author zhujiang.cheng
 * @since 2020/12/15
 */
@Component
public class ChangeBeanClassBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
        throws BeansException {
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("PrototypeBean");
        beanFactory.getBean("prototypeBean");
        beanDefinition.setBeanClass(SingletonBean.class);
    }
}
