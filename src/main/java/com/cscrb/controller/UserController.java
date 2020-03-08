package com.cscrb.controller;

import com.cscrb.entity.UserInfo;
import com.cscrb.service.UserService;
import com.cscrb.utils.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname UserController
 * @Description userController
 * @Date 2020/3/5 9:21
 */
@RestController
@RequestMapping(value = "/userController")
public class UserController {
    private Logger logger = LogUtils.get(UserController.class);

    @Autowired
    private UserService userService;

    //展示所有用户
    @PostMapping("/userList")
    public Response getAllUserList(){
        List<UserInfo> userInfoList = userService.showAllUserInfo();
        Response response = Response.newResponse();
        return response.setData(userInfoList);
    }

    //用户注册
    @PostMapping("/registerUser")
    public Response registerUser(@RequestBody UserInfo userInfo){
        Response response = Response.newResponse();
        try {
            if (StringUtils.isNotEmpty(userInfo.getUserName()) && StringUtils.isNotEmpty(userInfo.getPassWd())) {
                userService.insertUser(userInfo);
                return response.OK();
            } else {
                return response.setError(ErrorEnum.account_password_null);
            }
        } catch (Exception e){
            logger.info("用户注册失败");
            return response.setCodeAndMessage(9999,"用户注册失败");
        }
    }

    //用户登录
    @PostMapping("/userLogin")
    public Response login(@RequestBody UserInfo userInfo){
        Response response = Response.newResponse();
        String pwd = SHAPwd.signature(userInfo.getPassWd());
        userInfo.setPassWd(pwd);
        if (StringUtils.isNotEmpty(userService.findUser(userInfo).getId())){
            return response.OK();
        }
        return response.setError(ErrorEnum.account_password_err);
    }

    //根据id查询用户信息
    @PostMapping("/showUserInfo")
    public Response showUserInfo(Integer id){
        Response response = Response.newResponse();
        UserInfo userInfo = userService.selectByPrimary(id);
        return response.setData(userInfo);
    }

    //更改用户信息
    @PostMapping("/updateUserInfo")
    public Response updateUserInfo(@RequestBody UserInfo userInfo){
        Response response = Response.newResponse();
        if (StringUtils.isNotEmpty(userInfo.getId())){
            if (StringUtils.isNotEmpty(userInfo.getPassWd())){
                userInfo.setPassWd(SHAPwd.signature(userInfo.getPassWd()));
            }
            userService.updateUserInfo(userInfo);
            return response.OK();
        }
        return response.setCodeAndMessage(9999,"更改信息失败！");
    }
}
