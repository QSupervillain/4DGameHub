package com.cxk.dao;


import com.cxk.pojo.PspType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PspTypeDao{
    List<PspType> shoAll();
}
