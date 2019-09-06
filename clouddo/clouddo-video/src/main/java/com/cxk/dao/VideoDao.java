package com.cxk.dao;

import com.cxk.pojo.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface VideoDao {
    /**
     * 测试查询全部
     * @return
     */
    public List<Video> findAll();
    /**
     * 分页显示最新视屏页面
     */
    public List<Video> fenYeNewVideo();
}
