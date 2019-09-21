package com.cxk.service.Impl;

import com.cxk.dao.ScDao;
import com.cxk.pojo.Market;
import com.cxk.pojo.ScType;
import com.cxk.service.ScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/20 11:35
 * @Description：
 */
@Service
public class ScServiceImpl implements ScService {
    @Autowired(required = false)
    private ScDao scDao;

    @Override
    public List<Market> mklist() {
        return scDao.mklist();
    }

    @Override
    public List<ScType> sctypelist() {
        return scDao.sctypelist();
    }

    @Override
    public String sctypename(int id) {
        return scDao.sctypename(id);
    }

    @Override
    public int addmk(Market market) {
        return scDao.addmk(market);
    }

    @Override
    public Market showmk(int id) {
        return scDao.showmk(id);
    }

    @Override
    public int updatemk(Market market) {
        return scDao.updatemk(market);
    }
}