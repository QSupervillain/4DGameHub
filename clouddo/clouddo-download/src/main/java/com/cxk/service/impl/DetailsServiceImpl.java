package com.cxk.service.impl;

import com.cxk.dao.DetailsDao;
import com.cxk.pojo.Details;
import com.cxk.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/6 0:24
 * @Description：
 */

@Service
@Transactional
public class DetailsServiceImpl implements DetailsService {

    @Autowired
    private DetailsDao detailsDao;

    @Override
    public Details selById(Integer id) {
        return detailsDao.selById(id);
    }
}
