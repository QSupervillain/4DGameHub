package com.cxk.controller;

import com.cxk.pojo.Video;
import com.cxk.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;
    /**
     * 视屏新增
     */
    public int insertVideo(Video video){
        int num=0;
        return num;
    }
}
