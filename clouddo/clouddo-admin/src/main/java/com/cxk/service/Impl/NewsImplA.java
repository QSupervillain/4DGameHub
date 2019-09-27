package com.cxk.service.Impl;

import com.cxk.dao.NewsDaoA;
import com.cxk.pojo.GmNews;
import com.cxk.service.NewsServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author ：HeepEnd-ZH
 * @Date ：2019/9/21 1:44
 * @Description：
 */
@Service
public class NewsImplA implements NewsServiceA {
    @Autowired(required = false)
    private NewsDaoA newsDaoA;

    @Override
    public List<GmNews> showConditionNewsAll(Map<String, Object> newsCondition) {
        return newsDaoA.showConditionNewsAll(newsCondition);
    }

    @Override
    public int getNewsNumberOfBranches(Map<String, Object> newsCondition) {
        return newsDaoA.getNewsNumberOfBranches(newsCondition);
    }

    @Override
    //循环删除符合条件的数据
    public int updateNewsDaoA(List<Integer> newsIdList) {
        return newsDaoA.updateNewsDaoA(newsIdList);
    }

    //增加
    @Override
    public int addNews(Map<String, Object> newsCondition) {
        return newsDaoA.addNews(newsCondition);
    }

    //修改
    @Override
    public int updateNews(Map<String, Object> newsCondition) {
        return newsDaoA.updateNews(newsCondition);
    }
}
