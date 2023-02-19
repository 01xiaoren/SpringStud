package com.xiaoren.dao.impl;

import com.xiaoren.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplB implements UserDao {
    public void add() {
        System.out.println("userDaoImpl b .....");
    }
}
