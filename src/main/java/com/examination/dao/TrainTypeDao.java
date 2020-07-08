package com.examination.dao;

import com.examination.entity.TrainType;

import java.util.List;

public interface TrainTypeDao {
    //下拉框查询培训类型
    List<TrainType> SelectTrainType();
}
