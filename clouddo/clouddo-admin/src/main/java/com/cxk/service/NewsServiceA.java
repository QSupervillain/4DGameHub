package com.cxk.service;

import com.cxk.pojo.GmNews;

import java.util.List;
import java.util.Map;

public interface NewsServiceA {
    //查询所有符合条件的所有新闻并分页
    List<GmNews> showConditionNewsAll(Map<String, Object> newsCondition);
    //获取所有符合条件的所有新闻总条数
    int getNewsNumberOfBranches(Map<String, Object> newsCondition);
    //循环删除符合条件的数据
    int updateNewsDaoA(List<Integer> newsIdList);
    //新增数据
    int addNews(Map<String, Object> newsCondition);
    //修改数据
    int updateNews(Map<String, Object> newsCondition);
}
