package com.xiaoren.dao.impl;

import com.xiaoren.dao.EmpDao;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoImpl implements EmpDao {
    public int addEmp(Integer empno, String ename, String job) {
        System.out.println("empDao do .....");
        return 1;
    }
}
