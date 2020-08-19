package com.examination.service;

import com.examination.dao.TrainGenreDao;
import com.examination.entity.TrainGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TrainGenreService implements TrainGenreDao {
    @Autowired
    private TrainGenreDao trainGenreDao;

    //下拉框查询建造类型
    @Override
    public List<TrainGenre> SelectTrainGenre(Map map) {
        return trainGenreDao.SelectTrainGenre(map);
    }
}
