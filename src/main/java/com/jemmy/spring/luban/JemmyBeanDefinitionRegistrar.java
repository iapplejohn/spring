package com.jemmy.spring.luban;

import com.jemmy.spring.luban.annotation.JemmyScan;
import com.jemmy.spring.luban.dao.OrderMapper;
import com.jemmy.spring.luban.dao.UserMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhujiang.cheng
 * @since 2020/6/7
 */
public class JemmyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata,
        BeanDefinitionRegistry beanDefinitionRegistry) {

        Map<String, Object> map = annotationMetadata.getAnnotationAttributes(JemmyScan.class.getName());
        Object o = map.get("value");

        List<Class> mappers = new ArrayList<>();
        mappers.add(UserMapper.class);
        mappers.add(OrderMapper.class);

        for (Class mapper : mappers) {
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
            AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();

            beanDefinition.setBeanClass(JemmyFactoryBean.class);
//            beanDefinition.getConstructorArgumentValues().addArgumentValues(mapper);
            beanDefinitionRegistry.registerBeanDefinition(mapper.getName(), beanDefinition);
        }
    }
}
