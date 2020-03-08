package com.cscrb.entity;

/**
 * @Classname UserInfo
 * @Description 用户基本信息
 * @Date 2020/3/4 16:50
 */
public class UserInfo {
    private Integer id;

    private String userName;

    private String passWd;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
