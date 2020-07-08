package com.examination.dao;

import com.examination.entity.Ttype;

import java.util.List;
import java.util.Map;

public interface TtypeDao {
    //增加我的培训类型
    int InsertTtype(Map map);

    //删除我的配信类型
    int DeleteTtype(Map map);

    //修改我的培训类型
    int UpdateTtype(Map map);

    //查询我的培训类型
    List<Ttype> FindTtype(Map map);
}
