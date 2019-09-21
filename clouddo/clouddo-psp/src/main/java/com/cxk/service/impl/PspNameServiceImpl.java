package com.cxk.service.impl;

import com.cxk.dao.PspNameDao;
import com.cxk.pojo.PspName;
import com.cxk.service.PspNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ：WenBinZeng
 * @Date ：2019/9/11 11:07
 * @Description：
 */
@Service
public class PspNameServiceImpl implements PspNameService {
    @Autowired(required = false)
    private PspNameDao pspNameDao;


    @Override
    public List<PspName> pspnamelist() {
        return pspNameDao.pspnamelist();
    }
}