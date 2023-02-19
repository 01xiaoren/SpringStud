package com.xiaoren;

import com.xiaoren.config.springConfig;
import com.xiaoren.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
    @Test
    public void testGetBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
        userServiceImpl.cut();
    }

    @Test
    public void testGetBean1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(springConfig.class);
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
        userServiceImpl.cut();
    }
}
