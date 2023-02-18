package com.xiaoren.bean.BeanPostProcesser;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcesser implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //Object bean 实例化bean
        // String beanName bean的id
        System.out.println("bean初始化方法之前");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean初始化方法之后");
        return bean;
    }
}
