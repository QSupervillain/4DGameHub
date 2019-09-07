package com.cxk.controller;

import com.cxk.pojo.Video;
import com.cxk.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Video> findAll() {
       /* List<Video> list = videoService.findAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/
        return videoService.findAll();
    }

    /**
     * 分页显示
     * @return
     */
    @RequestMapping("/fenYeNewVideo")
    @ResponseBody
    public List<Video> fenYeNewVideo(){

        return videoService.fenYeNewVideo();
    }
    /**
     *根据视屏类型分页显示相应数据
     * @return
     */
    @RequestMapping("/pageVideo")
    @ResponseBody
    public List<Video> pageOriginalVideo(String video_type){
        //获取页面返回的信息
        int video_types =Integer.valueOf(video_type);
        System.out.println("video_types");
        return videoService.pageOriginalVideo(video_types);
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
