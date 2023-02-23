package com.xiaoren;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)// 指定测试支持类
@ContextConfiguration("classpath:applicationContext.xml")// 指定核心配置文件位置
public class Test01 {

    //案例
    /**
     *     @Autowired // 注入要获取的bean
     *     private  AccountService accountService;
     *         @Test()
     *     public void testTransaction(){
     *         int rows = accountService.transMoney(1, 2, 100);
     *         System.out.println(rows);
     *     }
     */
}
