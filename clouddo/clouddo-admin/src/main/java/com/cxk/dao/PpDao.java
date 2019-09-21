package com.cxk.dao;

import com.cxk.pojo.Psp;
import com.cxk.pojo.PspName;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PpDao {
    public List<Psp> pplist();
    public List<PspName> namelist();
    public int addpp(Psp psp);
    public int deletepp(int id);
    public Psp Ppbyid(int id);
}
