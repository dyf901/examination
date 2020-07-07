package com.examination.service;

import com.examination.dao.UserDao;
import com.examination.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService implements UserDao {
    @Autowired
    private UserDao userDao;

    //根据username查询账号信息
    @Override
    public User FindUserByUsername(Map map) {
        return userDao.FindUserByUsername(map);
    }
}
