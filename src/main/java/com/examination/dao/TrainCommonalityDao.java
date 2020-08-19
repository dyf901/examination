package com.examination.dao;

import com.examination.entity.TrainCommonality;

import java.util.List;
import java.util.Map;

public interface TrainCommonalityDao {
    //分页模糊查询公共课程
    List<TrainCommonality> FindTrainCommonality(Map map);

    //统计总数
    long Total(Map map);

    int CountAll(Map map);
}
