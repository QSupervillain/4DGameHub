package com.cxk.dao;

import com.cxk.pojo.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface VideoDao {
    public List<Video> findAll();
}
