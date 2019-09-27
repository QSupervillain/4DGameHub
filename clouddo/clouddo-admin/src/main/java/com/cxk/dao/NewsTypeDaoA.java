package com.cxk.dao;

import com.cxk.pojo.GmNewsType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsTypeDaoA {
    //查询所有新闻类型
    List<GmNewsType>showNewsTypeAll();
    //添加一条新闻类型
    int addNewsType(@Param("typeName") String typeName);
    //根据id修改一条新闻类型
    int updateNewsType(@Param("newsType") GmNewsType newsType);
    //根据id删除对应新闻类型
    int deleteNewsTypeByid(@Param("typeId") int typeId);
}
