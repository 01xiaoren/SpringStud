package com.xiaoren.bean;

import org.springframework.beans.factory.FactoryBean;

public class BookFactory implements FactoryBean<Book> {
    public Book getObject() throws Exception {
        Book book = new Book();
        book.setAuthor("1");
        book.setBname("java");
        return book;
    }

    public Class<?> getObjectType() {
        return null;
    }
}
