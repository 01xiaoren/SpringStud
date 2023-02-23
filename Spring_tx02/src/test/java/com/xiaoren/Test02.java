package com.xiaoren;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/*@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")*/
// 使用复合注解
@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class Test02 {
    //junit5的案例
    /**
     * @Autowired // 注入要获取的bean
     *     private  AccountService accountService;
     *     @Test
     *     public void testTransaction(){
     *         int rows = accountService.transMoney(1, 2, 100);
     *         System.out.println(rows);
     *     }
     */
}
