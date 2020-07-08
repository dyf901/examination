package com.examination.service;

import com.examination.dao.TrainContentDao;
import com.examination.entity.TrainContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TrainContentService implements TrainContentDao {
    @Autowired
    private TrainContentDao trainContentDao;

    @Override
    public TrainContent FindTrainContent(Map map) {
        return trainContentDao.FindTrainContent(map);
    }

    @Override
    public List<TrainContent> FindTrainContentAll() {
        return trainContentDao.FindTrainContentAll();
    }
}
