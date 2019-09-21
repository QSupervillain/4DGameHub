package com.cxk.service.Impl;

import com.cxk.dao.NewsTypeDaoA;
import com.cxk.pojo.GmNewsType;
import com.cxk.service.NewsTypeServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ：HeepEnd-ZH
 * @Date ：2019/9/18 10:52
 * @Description：
 */
@Service
public class NewsTypeImplA implements NewsTypeServiceA {
    @Autowired(required = false)
    private NewsTypeDaoA newsTypeDaoA;

    @Override
    public List<GmNewsType> showNewsTypeAll() {
        return newsTypeDaoA.showNewsTypeAll();
    }

    @Override
    public int addNewsType(String typeName) {
        return newsTypeDaoA.addNewsType(typeName);
    }

    @Override
    public int updateNewsType(GmNewsType gmNewsType) {
        return newsTypeDaoA.updateNewsType(gmNewsType);
    }

    @Override
    public int deleteNewsTypeByid(int typeId) {
        return newsTypeDaoA.deleteNewsTypeByid(typeId);
    }


}
