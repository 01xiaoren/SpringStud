package com.xiaoren;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.plaf.PanelUI;

public class Test01 {
    @Test
    public void testGetBean(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object emp = context.getBean("emp");
        System.out.println(emp);
    }
}
