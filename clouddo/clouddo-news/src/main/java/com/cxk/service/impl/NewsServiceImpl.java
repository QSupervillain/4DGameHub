package com.cxk.service.impl;

import com.cxk.dao.NewsDao;
import com.cxk.pojo.GmNews;
import com.cxk.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author ：HeepEnd-ZH
 * @Date ：2019/9/10 9:44
 * @Description：
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired(required = false)
    private NewsDao newsDao;

    //查询所有新闻
    @Override
    public List<GmNews> getNewsAll() {
        return newsDao.getNewsAll();
    }

    //查询与类型对应的新闻
    @Override
    public List<GmNews> getNewsByType() {
        return newsDao.getNewsByType();
    }

    //根据ID查询新闻
    @Override
    public GmNews getNewsByID(int newsID) {
        return newsDao.getNewsByID(newsID);
    }
}
