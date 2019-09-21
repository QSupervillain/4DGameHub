package com.cxk.service;


import com.cxk.pojo.GmNewsType;

import java.util.List;

public interface NewsTypeServiceA {
    //查询所有新闻类型
    List<GmNewsType> showNewsTypeAll();
    //添加一条新闻类型
    int addNewsType(String typeName);
    //根据id修改一条新闻类型
    int updateNewsType(GmNewsType newsType);
    //根据id删除对应新闻类型
    int deleteNewsTypeByid(int typeId);
}
