package com.cxk.service;

import com.cxk.pojo.Video;

import java.util.Date;
import java.util.List;

public interface VideoService {
    //添加视屏
    public int insertVideo(Video video);
    //修改视屏
    public int updateVideo(int video_id, String video_title, String video_content, Date video_date, int video_type);
    //根据id获取视屏数据
    public Video findById(int video_id);
    //删除视屏
    public int deleteVideo(int video_id);
    //显示视屏
    public List<Video> findAll();
}
