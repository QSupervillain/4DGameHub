package com.cxk.dao;

import com.cxk.pojo.Market;
import com.cxk.pojo.ScType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ScDao {
    public List<Market> mklist();
    public List<ScType> sctypelist();
    public String sctypename(int id);
    public int addmk(Market market);
    public Market showmk(int id);
    public int updatemk(Market market);
    public int deletesc(int id);
    public List<Market> mkmohu(String name);
}
