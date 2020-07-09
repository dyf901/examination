package com.examination.service;


import com.examination.dao.TrainContentDao;
import com.examination.dao.TrainContentWDao;
import com.examination.entity.TrainContent;
import com.examination.entity.TrainContentW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TrainContentWService implements TrainContentWDao {
    @Autowired
    private TrainContentWDao trainContentWDao;


    @Override
    public TrainContentW FindTrainContentW(Map map) {
        return trainContentWDao.FindTrainContentW(map);
    }

    @Override
    public List<TrainContentW> FindTrainContentWAll() {
        return trainContentWDao.FindTrainContentWAll();
    }
}
