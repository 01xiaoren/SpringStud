package com.xiaoren.bean;

public class User {
    private Integer userid;
    private String username;
    private String password;
    // TODO: 2023/2/18

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void initUser() {
        System.out.println("第三步:user初始化");
    }

    public User() {
        System.out.println("第一步：user构造");
    }

    public void destoryUser() {
        System.out.println("第五步：销毁user");
    }

    public User(Integer userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("第二步：username属性赋值");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
