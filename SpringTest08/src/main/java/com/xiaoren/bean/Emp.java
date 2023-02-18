package com.xiaoren.bean;

public class Emp {
    private Dept dept;

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }

    public Emp() {
    }

    public Emp(Dept dept) {
        this.dept = dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }
}
