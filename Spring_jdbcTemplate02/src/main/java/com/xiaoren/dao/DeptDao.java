package com.xiaoren.dao;

import com.xiaoren.pojo.Dept;

import java.util.List;

public interface DeptDao {
    int[] deptBatchAdd(List<Dept> depts);
    int[] deptBatchUpdate (List<Dept> depts);
    int[] deptBatchDelete(List<Integer> deptno);
}
