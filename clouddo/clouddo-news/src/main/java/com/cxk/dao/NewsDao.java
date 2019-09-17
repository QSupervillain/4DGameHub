package com.cxk.dao;

import com.cxk.pojo.GmNews;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsDao {
    //查询所有新闻
    List<GmNews> getNewsAll();
    //查询与类型对应的新闻
    List<GmNews> getNewsByType();
    //根据ID查询新闻
    GmNews getNewsByID(int newsID);
}
