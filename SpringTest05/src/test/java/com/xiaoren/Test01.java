package com.xiaoren;

import com.xiaoren.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Test01 {
    @Test
    public void testGetBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.getBookList());
        System.out.println(student.getBookMap());
        System.out.println(Arrays.toString(student.getBooks()));
        System.out.println(student.getBookSet());
        System.out.println(student.getBookList2());
    }
}
