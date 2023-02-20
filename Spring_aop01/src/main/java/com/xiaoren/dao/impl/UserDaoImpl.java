package com.xiaoren.dao.impl;

import com.xiaoren.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    public int addUser(Integer userid, String username) {
        System.out.println("userDao do ,.....");
//        int i = 1 / 0;
        return 1;
    }
}
