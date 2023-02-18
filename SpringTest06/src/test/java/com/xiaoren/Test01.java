package com.xiaoren;

import com.xiaoren.bean.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void testFactoryBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book = (Book) context.getBean("book");
        System.out.println(book.getAuthor());
        System.out.println(book.getBname());
        System.out.println(book.getClass());
        System.out.println(book);
    }
}
