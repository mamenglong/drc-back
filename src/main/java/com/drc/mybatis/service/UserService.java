/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2018/10/27
  Time: 17:10
  To change this template use File | Settings | File Templates.
*/
package com.drc.mybatis.service;

import com.drc.mybatis.entity.User;
import com.drc.mybatis.mapper.UserMapper;

public interface UserService extends UserMapper {

    Boolean isUserExist(User user);
    Boolean isUserNameExist(User user);

}
