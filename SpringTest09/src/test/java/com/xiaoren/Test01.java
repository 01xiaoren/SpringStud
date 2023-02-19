package com.xiaoren;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class Test01 {
    @Test
    public void testOut() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource);
    }
}
