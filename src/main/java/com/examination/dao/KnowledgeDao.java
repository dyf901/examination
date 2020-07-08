package com.examination.dao;

import com.examination.entity.Knowledge;

import java.util.List;
import java.util.Map;

public interface KnowledgeDao {
    //增加知识类型
    int InsertKnowledge(Map map);

    //删除知识类型
    int DeleteKnowledge(Map map);

    //修改知识类型
    int UpdateKnowledge(Map map);

    //分页查询知识类型
    List<Knowledge> FindKnowledge(Map map);

    //统计总数
    long Total();

    //下拉框知识类型
    List<Knowledge> SelectKnowledge();
}
