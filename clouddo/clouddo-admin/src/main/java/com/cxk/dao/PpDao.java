package com.cxk.dao;

import com.cxk.pojo.Psp;
import com.cxk.pojo.PspName;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PpDao {
    public List<Psp> pplist();
    public List<Psp> mohu(String pname);
    public List<PspName> namelist();
    public int addpp(Psp psp);
    public int deletepp(int id);
    public Psp Ppbyid(int id);
    public int updatepp(Psp psp);
    public List<Psp> mohupp(String name);
}
