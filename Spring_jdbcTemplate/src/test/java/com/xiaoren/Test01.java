package com.xiaoren;

import com.xiaoren.pojo.Emp;
import com.xiaoren.service.EmpService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class Test01 {
    @Test
    public void testCount() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationoContext.xml");
        EmpService bean = context.getBean(EmpService.class);
        //查询员工个数
       /* int empCount = bean.findEmpCount();
        System.out.println("一共" + empCount + "条数据");*/
        //根据员工编号查询员工对象
       /* Emp byEmpno = bean.findByEmpno(7566);
        System.out.println(byEmpno);*/
        //根据部门编号查询员工的对象集合
//        List<Emp> byDeptno = bean.findByDeptno(20);
//        byDeptno.forEach(System.out::println);
        //增加员工信息
     /*   int i = bean.addEmp(new Emp(null, "TOM", "SALESMAN", 7521, new Date(), 2000.0, 100.0, 10));
        System.out.println(i);*/
        /*根据员工编号修改员工信息*/
       /* int rows = bean.updateEmp(new Emp(7940, "JERRY", "MANAGER", 7839, new Date(), 3000.0, 0.0, 20));
        System.out.println(rows);*/
        //根据员工 编号删除员工信息
        int i = bean.deleteEmp(7940);
        if (i<0){
            System.out.println("失败");
        }else
            System.out.println("成功");
    }
}
