package com.cxk.service.Impl;

import com.cxk.dao.VideoDao;
import com.cxk.pojo.Video;
import com.cxk.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;
    @Override
    public int insertVideo(Video video) {
        return videoDao.insertVideo(video);
    }

    @Override
    public int updateVideo(int video_id) {
        return videoDao.updateVideo(video_id);
    }

    @Override
    public Video findById(int video_id) {
        return videoDao.findById(video_id);
    }

    @Override
    public int deleteVideo(int video_id) {
        return videoDao.deleteVideo(video_id);
    }
}
