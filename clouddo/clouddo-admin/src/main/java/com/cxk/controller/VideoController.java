package com.cxk.controller;

import com.cxk.pojo.Video;
import com.cxk.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;
    /**
     * 后台显示视屏信息
     */
    @RequestMapping("/videoslist")
    public String findAll(Model model){
        List<Video> videos = videoService.findAll();
        Video vi=new Video();
        System.out.println(videos);
        model.addAttribute("videos",videos);
        System.out.println(model);
        return "video-list";
    }
    /**
     * 视屏新增
     */
    public int insertVideo(Video video){
        int num=0;
        return num;
    }
    @RequestMapping("/test")
    public String test(){
        return "video-list";
    }
}
