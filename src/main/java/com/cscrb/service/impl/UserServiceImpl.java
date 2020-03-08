package com.cscrb.service.impl;

import com.cscrb.entity.UserInfo;
import com.cscrb.mapper.UserMapper;
import com.cscrb.service.UserService;
import com.cscrb.utils.SHAPwd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname UserServiceImpl
 * @Description UserSercice层的实现类
 * @Date 2020/3/4 17:00
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserInfo> showAllUserInfo() {
        return userMapper.showAllUser();
    }

    @Override
    public UserInfo findUser(UserInfo userInfo) {
        return userMapper.findByUser(userInfo);
    }

    @Override
    public UserInfo selectByPrimary(Integer id) {
        return userMapper.selectByPrimary(id);
    }

    @Override
    public void insertUser(UserInfo userInfo) {
        userInfo.setPassWd(SHAPwd.signature(userInfo.getPassWd()));
        userMapper.addUser(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userMapper.updateUserInfo(userInfo);
    }
}
