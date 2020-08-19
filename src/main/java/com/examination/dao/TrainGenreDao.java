package com.examination.dao;

import com.examination.entity.TrainGenre;

import java.util.List;
import java.util.Map;

public interface TrainGenreDao {
    //下拉框查询专业类型
    List<TrainGenre> SelectTrainGenre(Map map);
}
