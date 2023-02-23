package com.xiaoren.service.impl;

import com.xiaoren.dao.AccountDao;
import com.xiaoren.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional代表类中的所有方法控制事务
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

//    @Transactional//仅仅在当前方法上增加事务
    public int transMoney(int from, int to, int money) {
        //统计金钱
        int res = 0;
        //账号出钱
        res += accountDao.transMoney(from, 0 - money);
        //模拟异常
        int i = 1 / 0;
        //账号进钱
        res += accountDao.transMoney(to, money);
        return res;
    }
}
