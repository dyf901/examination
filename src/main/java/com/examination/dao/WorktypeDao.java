package com.examination.dao;

import com.examination.entity.Worktype;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface WorktypeDao {
    //增加工种
    int InsertWorktype(Map map);

    //删除工种
    int DeleteWorktype(Map map);

    //修改工种
    int UpdateWorktype(Map map);

    //分页模糊查询工种信息
    List<Worktype> FindWorktype(Map map);

    //统计总数
    long Total(Map map);

    //下拉框查询工种信息
    List<Worktype> SelectWorktype(Map map);

    //根据worktype_id查询工种信息
    Worktype FindWorktypeByWorktypeId(Map map);
}
