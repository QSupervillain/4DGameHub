package com.cxk.service.Impl;

import com.cxk.dao.VideoDao;
import com.cxk.pojo.Video;
import com.cxk.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;
    @Override
    public int insertVideo(String video_src,String video_image,String video_title, String video_content, Date video_date,int video_type) {
        return videoDao.insertVideo(video_src,video_image,video_title,video_content,video_date,video_type);
    }

    @Override
    public int updateVideo(int video_id, String video_title, String video_content, Date video_date, int video_type) {
        return videoDao.updateVideo(video_id, video_title,video_content, video_date, video_type);
    }

    @Override
    public Video findById(int video_id) {
        return videoDao.findById(video_id);
    }

    @Override
    public int deleteVideo(int video_id) {
        return videoDao.deleteVideo(video_id);
    }

    @Override
    public List<Video> findAll() {
        return videoDao.findAll();
    }

    @Override
    public List<Video> fuzzyQuery(String video_title) {

        return videoDao.fuzzyQuery(video_title);
    }
}
