package com.cxk.dao;

import com.cxk.pojo.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface VideoDao {
    //添加视屏
    public int insertVideo(Video video);
    //修改视屏
    public int updateVideo(int video_id);
    //根据id获取视屏数据
    public Video findById(int video_id);
    //显示视屏
    public List<Video> findAll();
    //删除视屏
    public int deleteVideo(int video_id);
}
