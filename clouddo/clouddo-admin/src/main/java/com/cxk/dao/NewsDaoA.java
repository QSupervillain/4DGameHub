package com.cxk.dao;

import com.cxk.pojo.GmNews;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface NewsDaoA {
    //查询所有符合条件的所有新闻并分页
        List<GmNews>showConditionNewsAll(@Param("newsCondition") Map<String, Object> newsCondition);
    //获取所有符合条件的所有新闻总条数
        int getNewsNumberOfBranches(@Param("newsCondition") Map<String, Object> newsCondition);
    //循环删除符合条件的数据
        int updateNewsDaoA(@Param("newsIdList") List<Integer> newsIdList);
    //新增数据
        int addNews(@Param("newsCondition") Map<String, Object> newsCondition);
    //修改数据
        int updateNews(@Param("newsCondition") Map<String, Object> newsCondition);
}
