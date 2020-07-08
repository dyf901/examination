package com.examination.dao;

import com.examination.entity.TrainGenre;

import java.util.List;

public interface TrainGenreDao {
    //下拉框查询专业类型
    List<TrainGenre> SelectTrainGenre();
}
