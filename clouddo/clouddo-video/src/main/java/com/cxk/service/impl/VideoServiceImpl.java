package com.cxk.service.impl;

import com.cxk.dao.VideoDao;
import com.cxk.pojo.Video;
import com.cxk.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;
    @Override
    public List<Video> findAll() {
        return videoDao.findAll();
    }

    /**
     * 根据点击相应视屏进入对应视屏详情播放页
     *
     * @param video_id
     */
    @Override
    public List<Video> videoDescribe(int video_id) {
        return videoDao.videoDescribe(video_id);
    }

    /**
     * 分页显示原创视频
     */
    @Override
    public List<Video> pageOriginalVideo(int video_type) {
        return videoDao.pageOriginalVideo(video_type);
    }

    /**
     * 分页显示最新视屏页面
     */
    @Override
    public List<Video> fenYeNewVideo() {
        return videoDao.fenYeNewVideo();
    }
}
