package com.examination.service;

import com.examination.dao.ExamRecordDao;
import com.examination.entity.ExamRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExamRecordService implements ExamRecordDao {
    @Autowired
    private ExamRecordDao examRecordDao;

    @Override
    public int InsertExamRecord(Map map) {
        return examRecordDao.InsertExamRecord(map);
    }

    @Override
    public int DeleteExamRecord(Map map) {
        return examRecordDao.DeleteExamRecord(map);
    }

    @Override
    public List<ExamRecord> FindExamRecord(Map map) {
        return examRecordDao.FindExamRecord(map);
    }

    @Override
    public long Total() {
        return examRecordDao.Total();
    }

    @Override
    public List<ExamRecord> FindExamRecordByStaffId(Map map) {
        return examRecordDao.FindExamRecordByStaffId(map);
    }

    @Override
    public List<ExamRecord> FindExamRecordByStaffIdALL(Map map) {
        return examRecordDao.FindExamRecordByStaffIdALL(map);
    }

    @Override
    public int CountT() {
        return examRecordDao.CountT();
    }

    @Override
    public int CountAll() {
        return examRecordDao.CountAll();
    }
}
