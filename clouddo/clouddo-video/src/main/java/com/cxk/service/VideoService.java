package com.cxk.service;

import com.cxk.pojo.Video;

import java.util.List;
public interface VideoService {
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
