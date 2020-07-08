package com.examination.service;

import com.examination.dao.TtypeDao;
import com.examination.entity.Ttype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class TtypeService implements TtypeDao {
    @Autowired
    private TtypeDao ttypeDao;

    @Override
    public int InsertTtype(Map map) {
        return ttypeDao.InsertTtype(map);
    }

    @Override
    public int DeleteTtype(Map map) {
        return ttypeDao.DeleteTtype(map);
    }

    @Override
    public int UpdateTtype(Map map) {
        return ttypeDao.UpdateTtype(map);
    }

    @Override
    public List<Ttype> FindTtype(Map map) {
        return ttypeDao.FindTtype(map);
    }
}
