
package com.xiaoren;

import com.xiaoren.config.SpringConfig;
import com.xiaoren.dao.UserDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    //半注解开发
    @Test
    public void getBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = context.getBean(UserDao.class);
        userDao.addUser(1, "XIAO");
    }
    //出注解开发
    @Test
    public void testGetBean1(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao bean = annotationConfigApplicationContext.getBean(UserDao.class);
        bean.addUser(2,"西OMIGBJKAGWEKVJ");
    }
}

