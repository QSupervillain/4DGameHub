package com.cxk.dao;

import com.cxk.pojo.PspName;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PspNameDap {
    List<PspName>showAll();
}
