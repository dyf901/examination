package com.examination.service;

import com.examination.dao.TrainDao;
import com.examination.entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TrainService implements TrainDao {
    @Autowired
    private TrainDao trainDao;

    @Override
    public int InsertTrain(Map map) {
        return trainDao.InsertTrain(map);
    }

    @Override
    public int DeleteTrain(Map map) {
        return trainDao.DeleteTrain(map);
    }

    @Override
    public int UpdateTrain(Map map) {
        return trainDao.UpdateTrain(map);
    }

    @Override
    public List<Train> FindTrain(Map map) {
        return trainDao.FindTrain(map);
    }

    @Override
    public long Total(Map map) {
        return trainDao.Total(map);
    }

    @Override
    public Train FindTrainByIdX(Map map) {
        return trainDao.FindTrainByIdX(map);
    }

    @Override
    public List<Train> FindTrainAll(Map map) {
        return trainDao.FindTrainAll(map);
    }

    @Override
    public int CountAll(Map map) {
        return trainDao.CountAll(map);
    }
}
