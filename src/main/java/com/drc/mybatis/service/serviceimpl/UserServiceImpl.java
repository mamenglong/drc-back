/*
  Created by IntelliJ IDEA.
  User: Long
  Date: 2018/10/27
  Time: 17:08
  To change this template use File | Settings | File Templates.
*/
package com.drc.mybatis.service.serviceimpl;

import com.drc.mybatis.entity.User;
import com.drc.mybatis.mapper.UserMapper;
import com.drc.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }
    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public Boolean isUserExist(User user) {
        HashSet<User> hashSet=new HashSet<User>();
        hashSet.addAll(userMapper.selectAll());
        if(hashSet.contains(user))
           return true;
        else
           return false;
//       User get= userMapper.getUser(user);
//       if(get!=null&&get.getId()>0){
//           return true;
//       }else
//           return false;

//        List<User> gets= userMapper.selectAll();
//        for (User usr:gets ) {
//            if(user.getEmail()==usr.getEmail()&&user.getPassword()==usr.getPassword())
//                return true;
//        }
//        return false;
    }

    @Override
    public Boolean isUserNameExist(User user) {
        List<User> gets= userMapper.selectAll();
        if(gets.size()==0){
            return false;
        }
        for (User usr:gets ) {
            if(user.getUsername().equals(usr.getUsername()))
                return true;
        }
        return false;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }
}
