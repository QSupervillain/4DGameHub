package com.cxk.service;

import com.cxk.pojo.Market;
import com.cxk.pojo.ScType;

import java.util.List;

public interface ScService {
    public List<Market> mklist();
    public List<ScType> sctypelist();
    public String sctypename(int id);
    public int addmk(Market market);
    public Market showmk(int id);
    public int updatemk(Market market);
    public int deletesc(int id);
    public List<Market> mkmohu(String name);
}
