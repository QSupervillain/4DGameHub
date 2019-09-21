package com.cxk.service.Impl;

import com.cxk.dao.PpDao;
import com.cxk.pojo.Psp;
import com.cxk.pojo.PspName;
import com.cxk.service.PpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/18 11:00
 * @Description：
 */
@Service
public class PpServiceImpl implements PpService {
    @Autowired(required = false)
    private PpDao ppDao;


    @Override
    public List<Psp> pplist() {
        return ppDao.pplist();
    }

    @Override
    public List<PspName> namelist() {
        return ppDao.namelist();
    }

    @Override
    public int addpp(Psp psp) {
        return ppDao.addpp(psp);
    }

    @Override
    public int deletepp(int id) {
        return ppDao.deletepp(id);
    }

    @Override
    public Psp Ppbyid(int id) {
        return ppDao.Ppbyid(id);
    }
}