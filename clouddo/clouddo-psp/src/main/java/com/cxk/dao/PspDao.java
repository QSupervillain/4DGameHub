package com.cxk.dao;

import com.cxk.pojo.Psp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PspDao {
     //主页分页
     List<Psp> fenye();

     //根据ID查看详情
     public Psp details(int id);
}
