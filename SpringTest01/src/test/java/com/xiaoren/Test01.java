package com.xiaoren;

import com.xiaoren.dao.EmpDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//通过容器获取对象
public class Test01 {
    @Test
    public void TestGetBean() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        EmpDao empDao = context.getBean("empDao", EmpDao.class);
        empDao.addEmp();
    }
}
