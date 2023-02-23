package com.xiaoren;

import com.xiaoren.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    @Test
    public void testTx() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService bean = context.getBean(AccountService.class);
        int i = bean.transMoney(2, 1, 100);
        System.out.println(i);
    }
}
