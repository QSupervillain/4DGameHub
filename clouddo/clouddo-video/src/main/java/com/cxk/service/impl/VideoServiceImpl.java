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
     * 分页显示最新视屏页面
     */
    @Override
    public List<Video> fenYeNewVideo() {
        return videoDao.fenYeNewVideo();
    }
}
