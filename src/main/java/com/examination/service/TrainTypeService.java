package com.examination.service;

import com.examination.dao.TrainTypeDao;
import com.examination.entity.TrainType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrainTypeService implements TrainTypeDao {
    @Autowired
    private TrainTypeDao trainTypeDao;

    //下拉框查询培训类型
    @Override
    public List<TrainType> SelectTrainType() {
        return trainTypeDao.SelectTrainType();
    }
}
