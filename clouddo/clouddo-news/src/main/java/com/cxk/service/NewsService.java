package com.cxk.service;

import com.cxk.pojo.GmNews;

import java.util.List;

public interface NewsService {
    //查询所有新闻
    List<GmNews> getNewsAll();
    //查询与类型对应的新闻
    List<GmNews> getNewsByType();
    //根据ID查询新闻
    GmNews getNewsByID(int newsID);
}


