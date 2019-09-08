package com.cxk.service.impl;

import com.cxk.dao.PspTypeDao;
import com.cxk.pojo.PspType;
import com.cxk.service.PspTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/5 19:59
 * @Description：
 */
@Service
public class PspTypeServiceImpl implements PspTypeService {

    @Autowired(required = false)
    private PspTypeDao pspTypeDao;

    @Override
    public List<PspType> shoAll() {
        return pspTypeDao.shoAll();
    }
}