package com.xiaoren;

import com.xiaoren.pojo.Dept;
import com.xiaoren.service.DeptService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test01 {
    //向dept表中增加10条数据
    @Test
    public void testBatchAdd() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService bean = context.getBean(DeptService.class);
        List<Dept> depts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            depts.add(new Dept(null, "name" + i, "loc" + i));
        }
        int[] ints = bean.deptBatchAdd(depts);
        System.out.println(Arrays.toString(ints));
    }

    //修改dept表中的数据
    @Test
    public void testBathUpdate() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService bean = context.getBean(DeptService.class);
        List<Dept> depts = new ArrayList<>();
        for (int i = 48; i <= 57; i++) {
            depts.add(new Dept(i, "newname", "newloc"));
        }
        int[] ints = bean.deptBatchUpdate(depts);
        System.out.println(Arrays.toString(ints));
    }

    //删除dept表中的10条数据
    @Test
    public void testBathDelete() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptService bean = context.getBean(DeptService.class);
        List<Integer> depts = new LinkedList<>();
        for (int i = 48; i < 57; i++) {
            depts.add(i);
        }
        int[] ints = bean.deptBatchDelete(depts);
        System.out.println(Arrays.toString(ints));
    }
}
