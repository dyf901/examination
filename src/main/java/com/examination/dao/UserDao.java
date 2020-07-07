package com.examination.dao;

import com.examination.entity.User;

import java.util.Map;

public interface UserDao {
    //根据username查询账号信息
    User FindUserByUsername(Map map);
}
