package com.cxk.service;

import com.cxk.pojo.Psp;

import java.util.List;

public interface PspService {
    public List<Psp> fenye(int id);
    public Psp details(int id);
    public List<Psp> showbytypeid(int id,int typeid);
}
