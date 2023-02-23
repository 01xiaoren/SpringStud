package com.xiaoren.dao.impl;

import com.xiaoren.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int transMoney(int id, int money) {
        //进钱为正；出钱为负数
        String sql = "update account set money = money + ? where id = ?";
        //参数根据问好的循序
        int update = jdbcTemplate.update(sql, money,id);
        return update;
    }
}
