package com.xiaoren.service.impl;

import com.xiaoren.dao.UserDao;
import com.xiaoren.dao.impl.UserDaoImplB;
import com.xiaoren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //    private UserDao userDao = new UserDaoImplB()
    //自动装配
    /***
     * *@Autowired
     *     * 根据类型到容器中去寻找对应的对象,找到后给当前属性赋值
     *     * 不需要依赖 set方法
     *     * 属性类型可以是接口,会自动匹配对应的实现类对象
     *     * @Autowired配合 @Qualifier,可以通过名称指定注入的对象
     */
    @Qualifier("userDaoImplA")
    @Autowired
    private UserDao userDao;
    @Value("张三")
    private String sname;
    @Value("男")
    private String sgender;
    @Value("17")
    private Integer sage;

    public void cut() {
        userDao.add();
        System.out.println("userService......");
        System.out.println(sname);
        System.out.println(sgender);
        System.out.println(sage);
    }
}
