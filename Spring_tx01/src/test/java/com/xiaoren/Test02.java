package com.xiaoren;

import com.xiaoren.config.SpringConfig;
import com.xiaoren.service.AccountService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//纯注解测试
public class Test02 {
    @Test
    public void testTx() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService bean = context.getBean(AccountService.class);
        int i = bean.transMoney(1, 2, 100);
        System.out.println(i);
    }
}
