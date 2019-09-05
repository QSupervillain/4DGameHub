package com.cxk.service.impl;

import com.cxk.dao.GameTypeDao;
import com.cxk.pojo.GameType;
import com.cxk.service.GameTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/5 0:24
 * @Description：
 */
@Service
@Transactional
public class GameTypeServiceImpl implements GameTypeService {

    @Autowired
    private GameTypeDao gameTypeDao;

    @Override
    public List<GameType> getAll() {
        return gameTypeDao.getAll();
    }
}
