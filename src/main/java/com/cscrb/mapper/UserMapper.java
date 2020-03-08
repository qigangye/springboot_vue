package com.cscrb.mapper;

import com.cscrb.entity.UserInfo;

import java.util.List;

/**
 * @Classname UserMapper
 * @Description 用户信息mapper层接口
 * @Date 2020/3/4 16:51
 */
public interface UserMapper {
    //展示所有用户
    List<UserInfo> showAllUser();

    //根据用户信息返回用户
    UserInfo findByUser(UserInfo userInfo);

    //根据主键查看用户信息
    UserInfo selectByPrimary(Integer id);

    //新增用户
    void addUser(UserInfo userInfo);

    //修改用户信息
    void updateUserInfo(UserInfo userInfo);
}
