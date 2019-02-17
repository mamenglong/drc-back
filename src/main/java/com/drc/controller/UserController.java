/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2019/2/16
  Time: 13:40
  To change this template use File | Settings | File Templates.
*/
package com.drc.controller;

import com.drc.model.Responsed;
import com.drc.model.UserDTO;
import com.drc.mybatis.entity.User;
import com.drc.mybatis.service.UserService;
import com.drc.utils.DateUtil;
import com.drc.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Responsed login(UserDTO userDTO){
        LogUtil.debug(userDTO.toJson());
        Responsed responsed=new Responsed();
        User user=new User();
        user.setUsername(userDTO.getUserName());
        user.setPassword(userDTO.getPassWord());
        user.setUniquecode(userDTO.getUniqueCode());
       if (userService.isUserExist(user)){
          responsed.setStatus(Responsed.Success)
                  .setMsg("允许登陆！")
                  .setException("无")
                  .setTimestamp(DateUtil.getNow(null));
       }else{
           responsed.setStatus(Responsed.Fail)
                   .setMsg("账号、密码错误或设备不是指定设备！")
                   .setException("无")
                   .setTimestamp(DateUtil.getNow(null));
       }
        LogUtil.info(responsed.toJson());
        return responsed;
    }

    @PostMapping("/register")
    public Responsed register(UserDTO userDTO){
        LogUtil.debug(userDTO.toJson());
        Responsed responsed=new Responsed();
        User user=new User();
        user.setUsername(userDTO.getUserName());
        user.setPassword(userDTO.getPassWord());
        user.setUniquecode(userDTO.getUniqueCode());
        if (userService.insert(user)>0){
            responsed.setStatus(Responsed.Success)
                    .setMsg("注册成功！")
                    .setException("注册成功！")
                    .setTimestamp(DateUtil.getNow(null));
        }else{
            responsed.setStatus(Responsed.Fail)
                    .setMsg("注册失败，请稍后再试！")
                    .setException("注册失败，请稍后再试！")
                    .setTimestamp(DateUtil.getNow(null));
        }
        LogUtil.info(responsed.toJson());
        return responsed;
    }

    @PostMapping("/isUsernameExist")
    public Responsed isUsernameExist(String userName){
        User user=new User();
        user.setUsername(userName);
        Responsed responsed=new Responsed();
        if(!userService.isUserNameExist(user)){
            responsed.setStatus(Responsed.Success)
                    .setMsg("用户不存在可以注册！")
                    .setException("检测成功！")
                    .setTimestamp(DateUtil.getNow(null));
        }else {
            responsed.setStatus(Responsed.Fail)
                    .setMsg("用户已存在不可以注册！")
                    .setException("请更换用户名！")
                    .setTimestamp(DateUtil.getNow(null));
        }
        return responsed;
    }
}
