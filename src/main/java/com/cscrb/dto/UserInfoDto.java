package com.cscrb.dto;

/**
 * @Classname UserInfoDto
 * @Description 用户信息dto类
 * @Date 2020/3/7 16:04
 * @Created by gangye
 */
public class UserInfoDto {
    private Integer id;

    private String userName;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
