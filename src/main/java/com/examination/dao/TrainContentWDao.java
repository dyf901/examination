package com.examination.dao;

import com.examination.entity.TrainContentW;

import java.util.List;
import java.util.Map;

public interface TrainContentWDao {
    //根据id查询培训内容
    TrainContentW FindTrainContentW(Map map);

    //查询全部展馆体验
    List<TrainContentW> FindTrainContentWAll();

}
