package com.cxk.service;

import com.cxk.pojo.GmNews;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NewsServiceA {
    //查询所有符合条件的所有新闻并分页
    List<GmNews> showConditionNewsAll(@Param("newsCondition") Map<String ,Object> newsCondition);
    //获取所有符合条件的所有新闻总条数
    int getNewsNumberOfBranches(@Param("newsCondition") Map<String ,Object>newsCondition);

}
