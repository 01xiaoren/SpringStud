
package com.xiaoren;

import com.xiaoren.bean.Cat;
import com.xiaoren.bean.Mouse;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

public class Test01 {
    @Test
    public void testGetBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        Mouse mouse = context.getBean("mouse1", Mouse.class);
        System.out.println(mouse);

        System.out.println("------------");
        Cat cat = (Cat) context.getBean("cat2");
        System.out.println(cat);

    }
}
