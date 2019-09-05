package com.cxk.controller;

import com.cxk.pojo.Video;
import com.cxk.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;
    /*@RequestMapping("/findAll")
    @ResponseBody*/
    public List<Video> findAll() {
        return videoService.findAll();
    }
}
