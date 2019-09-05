package com.cxk.controller;

import com.cxk.pojo.Video;
import com.cxk.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;
    @RequestMapping("/findAll")
    public List<Video> findAll() {
        return videoService.findAll();
    }
}
