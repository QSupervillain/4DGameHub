package com.cxk.service.impl;

import com.cxk.dao.DownLoadDao;
import com.cxk.pojo.DownLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/5 15:23
 * @Description：
 */
@Service
@Transactional
public class DownLoadServiceImpl implements DownLoadDao {

    @Autowired
    private DownLoadDao downLoadDao;

    @Override
    public List<DownLoad> getAll() {
        return downLoadDao.getAll();
    }
}
