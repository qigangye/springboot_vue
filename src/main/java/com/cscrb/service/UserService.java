package com.cscrb.service;

import com.cscrb.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname UserService
 * @Description 用户的service层
 * @Date 2020/3/4 16:57
 * @Created by gangye
 */
public interface UserService {
    List<UserInfo> showAllUserInfo();

    UserInfo findUser(UserInfo userInfo);

    UserInfo selectByPrimary(Integer id);

    void insertUser(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);
}
