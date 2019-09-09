package com.cxk.dao;

import com.cxk.pojo.GmNewsType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsTypeDao {

    List<GmNewsType> getAll();

}
