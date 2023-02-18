package com.xiaoren;

import com.xiaoren.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user");
        System.out.println("第四步：user从容器中获取");
        //关闭容器c
        context.close();
    }
}
