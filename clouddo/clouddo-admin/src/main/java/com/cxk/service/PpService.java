package com.cxk.service;

import com.cxk.pojo.Psp;
import com.cxk.pojo.PspName;

import java.util.List;

public interface PpService {
    public List<Psp> pplist();
    public List<Psp> mohu(String pname);
    public List<PspName> namelist();
    public int addpp(Psp psp);
    public int deletepp(int id);
    public Psp Ppbyid(int id);
    public int updatepp(Psp psp);
}
