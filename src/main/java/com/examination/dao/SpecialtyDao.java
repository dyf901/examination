package com.examination.dao;

import com.examination.entity.Specialty;

import java.util.List;
import java.util.Map;

public interface SpecialtyDao {
    //增加专业类型
    int InsertSpecialty(Map map);

    //删除专业类型
    int DeleteSpecialty(Map map);

    //修改专业类型
    int UpdateSpecialty(Map map);

    //分页查询专业类型
    List<Specialty> FindSpecialty(Map map);

    //统计总数
    long Total();

    //下拉框查询专业类型
    List<Specialty> SelectSpecialty();
}
