package com.examination.dao;

import com.examination.entity.Staff;

import java.util.List;
import java.util.Map;

public interface StaffDao {
    //增加员工信息
    int InsertStaff(Map map);

    //删除员工信息
    int DeleteStaff(Map map);

    //修改员工信息
    int UpdateStaff(Map map);

    //分页模糊查询员工信息
    List<Staff> FindStaff(Map map);

    //统计总数
    long Total(Map map);

    //根据staff_phone查询员工信息
    Staff FindStaffByStaffPhone(Map map);
}
