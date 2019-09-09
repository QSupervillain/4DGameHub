package com.cxk.service.impl;

import com.cxk.dao.PspDao;
import com.cxk.pojo.Psp;
import com.cxk.service.PspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/8 15:09
 * @Description：游戏攻略
 */
@Service
public class PspServiceImpl implements PspService {
    @Autowired(required = false)
    private PspDao pspDao;
    @Override
    public List fenye() {
        return pspDao.fenye();
    }

    @Override
    public Psp details(int id) {
        return pspDao.details(id);
    }
}