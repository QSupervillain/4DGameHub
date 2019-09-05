package com.cxk.service.impl;

import com.cxk.dao.DownLoadDao;
import com.cxk.pojo.DownLoad;
import com.cxk.service.DownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/5 15:23
 * @Description：
 */
@Service
@Transactional
public class DownLoadServiceImpl implements DownLoadService {

    @Autowired
    private DownLoadDao downLoadDao;

    @Override
    public List<DownLoad> getAll(Map<String, Object> map) {
        return downLoadDao.getAll(map);
    }
}
