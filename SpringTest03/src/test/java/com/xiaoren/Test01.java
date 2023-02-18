package com.xiaoren;

import com.xiaoren.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void testGetBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User bean = context.getBean("user1", User.class);
        System.out.println(bean);
        System.out.println("------------------");
        User user2 = context.getBean("user2", User.class);
        System.out.println(user2);
        System.out.println("-------------");
        User user3 = context.getBean("user3", User.class);
        System.out.println(user3);
        System.out.println("------------");
        User user4 = (User) context.getBean("user4");
        System.out.println(user4);
        System.out.println("-----------");
        User user5 = (User) context.getBean("user5");
        System.out.println(user5);
    }
}
