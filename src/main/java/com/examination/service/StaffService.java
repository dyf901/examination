package com.examination.service;

import com.examination.dao.StaffDao;
import com.examination.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StaffService implements StaffDao {
    @Autowired
    private StaffDao staffDao;

    //增加员工信息
    @Override
    public int InsertStaff(Map map) {
        return staffDao.InsertStaff(map);
    }

    //增加员工信息S
    @Override
    public int InsertStaffS(Staff staff) {
        return staffDao.InsertStaffS(staff);
    }

    //删除员工信息
    @Override
    public int DeleteStaff(Map map) {
        return staffDao.DeleteStaff(map);
    }

    //修改员工信息
    @Override
    public int UpdateStaff(Map map) {
        return staffDao.UpdateStaff(map);
    }

    //修改员工信息S
    @Override
    public int UpdateStaffS(Staff staff) {
        return staffDao.UpdateStaffS(staff);
    }

    //分页模糊查询员工信息
    @Override
    public List<Staff> FindStaff(Map map) {
        return staffDao.FindStaff(map);
    }

    //统计总数
    @Override
    public long Total(Map map) {
        return staffDao.Total(map);
    }

    //根据staff_phone查询员工信息
    @Override
    public Staff FindStaffByStaffPhone(Map map) {
        return staffDao.FindStaffByStaffPhone(map);
    }

    //根据staff_phone统计总数
    @Override
    public int CountStaff(String staff_phone) {
        return staffDao.CountStaff(staff_phone);
    }

    @Override
    public int CountAll() {
        return staffDao.CountAll();
    }

    @Override
    public Staff FindStaffByStaffCard(Map map) {
        return staffDao.FindStaffByStaffCard(map);
    }
}
