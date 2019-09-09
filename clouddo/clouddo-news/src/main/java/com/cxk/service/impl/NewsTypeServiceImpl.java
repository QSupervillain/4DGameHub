package com.cxk.service.impl;

import com.cxk.dao.NewsTypeDao;
import com.cxk.pojo.GmNewsType;
import com.cxk.service.NewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author ：HeepEnd-ZH
 * @Date ：2019/9/9 16:58
 * @Description：
 */

@Service
@Transactional
public class NewsTypeServiceImpl implements NewsTypeService {

    @Autowired(required = false)
    private NewsTypeDao NewsTypeDao;

    @Override
    public List<GmNewsType> getAll() {
        return NewsTypeDao.getAll();
    }
}
