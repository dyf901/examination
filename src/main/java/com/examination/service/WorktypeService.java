package com.examination.service;

import com.examination.dao.WorktypeDao;
import com.examination.entity.Worktype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorktypeService implements WorktypeDao {
    @Autowired
    private WorktypeDao worktypeDao;//工种

    //增加工种
    @Override
    public int InsertWorktype(Map map) {
        return worktypeDao.InsertWorktype(map);
    }

    //删除工种
    @Override
    public int DeleteWorktype(Map map) {
        return worktypeDao.DeleteWorktype(map);
    }

    //修改工种
    @Override
    public int UpdateWorktype(Map map) {
        return worktypeDao.UpdateWorktype(map);
    }

    //分页模糊查询工种信息
    @Override
    public List<Worktype> FindWorktype(Map map) {
        return worktypeDao.FindWorktype(map);
    }

    //统计总数
    @Override
    public long Total(Map map) {
        return worktypeDao.Total(map);
    }

    //下拉框查询工种信息
    @Override
    public List<Worktype> SelectWorktype(Map map) {
        return worktypeDao.SelectWorktype(map);
    }

    //根绝worktype_id查询工种信息
    @Override
    public Worktype FindWorktypeByWorktypeId(Map map) {
        return worktypeDao.FindWorktypeByWorktypeId(map);
    }
}
