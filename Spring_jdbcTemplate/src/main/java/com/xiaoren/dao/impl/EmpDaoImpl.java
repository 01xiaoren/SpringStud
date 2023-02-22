package com.xiaoren.dao.impl;

import com.xiaoren.dao.EmpDao;
import com.xiaoren.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDaoImpl implements EmpDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int findEmpCount() {
        /* *
        查询员工个数
         * queryForObject 两个参数
         * 1 SQL语句
         * 2 返回值类型
         */
        String sql = "select count(1) from emp ";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        return integer;
    }

    @Override
    public Emp findByEmpno(int empno) {
        /**
         * 查询单个员工对象
         * queryForObject三个参数
         * 1 SQL语句
         * 2 RowMapper接口的实现类对象,用于执行返回的结果用哪个类来进行封装 ,实现类为BeanPropertyRowMapper
         * 3 SQL语句中需要的参数 (可变参数)
         */
        BeanPropertyRowMapper rowMapper = new BeanPropertyRowMapper(Emp.class);
        Emp emp = (Emp) jdbcTemplate.queryForObject("select * from emp where empno =?", rowMapper, empno);
        return emp;
    }

    @Override
    public List<Emp> findByDeptno(int deptno) {
        /**
         * 根据部门编号查询多个员工对象集合
         * query三个参数
         * 1 SQL语句
         * 2 RowMapper接口的实现类对象,用于执行返回的结果用哪个类来进行封装 ,实现类为BeanPropertyRowMapper
         * 3 SQL语句中需要的参数 (可变参数)
         * */
        BeanPropertyRowMapper rowMapper = new BeanPropertyRowMapper(Emp.class);
        List<Emp> emp = (List<Emp>) jdbcTemplate.query("select * from emp where deptno =? ", rowMapper, deptno);
        return emp;
    }

    @Override
    public int addEmp(Emp emp) {
        /**
         /*增删改
         * 统统用update方法 两个参数
         * 1 SQL语句
         * 2 SQL语句需要的参数 (可变参数)
         */
        String sql = "insert into emp values(DEFAULT ,?,?,?,?,?,?,?)";
        Object[] args = {emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), emp.getSal(), emp.getComm(), emp.getDeptno()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updateEmp(Emp emp) {
        String sql ="update emp set ename =? , job =?, mgr=? , hiredate =?, sal=?, comm=?, deptno =? where empno =?";
        Object[] args ={emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno(),emp.getEmpno()};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public int deleteEmp(int empno) {
        String sql = "delete from emp where empno =?";
        return jdbcTemplate.update(sql,empno);
    }
}
