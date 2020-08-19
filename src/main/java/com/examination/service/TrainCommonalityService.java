package com.examination.service;

import com.examination.dao.TrainCommonalityDao;
import com.examination.entity.TrainCommonality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TrainCommonalityService implements TrainCommonalityDao {
    @Autowired
    private TrainCommonalityDao trainCommonalityDao;//公共课程

    //分页模糊查询公共课程
    @Override
    public List<TrainCommonality> FindTrainCommonality(Map map) {
        return trainCommonalityDao.FindTrainCommonality(map);
    }

    //统计总数
    @Override
    public long Total(Map map) {
        return trainCommonalityDao.Total(map);
    }

    @Override
    public int CountAll(Map map) {
        return trainCommonalityDao.CountAll(map);
    }
}
