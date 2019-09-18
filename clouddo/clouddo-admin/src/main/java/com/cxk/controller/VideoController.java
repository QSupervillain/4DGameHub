package com.cxk.controller;

import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.cxk.pojo.Video;
import com.cxk.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
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
        model.addAttribute("videos",videos);
        //System.out.println(model);
        return "video-list";
    }
    @RequestMapping("/findById")
    public String findById(Model model, String video_id){
        //获取id
        //System.out.println("join**************************");
        int video_ids=Integer.valueOf(video_id);
        //System.out.println(video_ids);
        Video videoById = videoService.findById(video_ids);
        model.addAttribute("videoById",videoById);
        //System.out.println(model);
        return "videos-edit";
    }
    @RequestMapping("/updateVideo")
    @ResponseBody
    public void updateVideo(String video_ids,String video_title ,String video_content ,String video_types ){
        //获取修改数据
        System.out.println("join******************************************************");
        int video_id=Integer.valueOf(video_ids);
        System.out.println(video_id);
        int video_type=Integer.valueOf(video_types);
        System.out.println(video_type);
        System.out.println(video_title);
        int i = videoService.updateVideo(video_id, video_title, video_content, new Date(), video_type);
        //return "index";
    }
    @RequestMapping("/deleteVideoByid")
    @ResponseBody
    public void deleteVoidById(String id){
        //System.out.println("join************deleteVideoByid");
        int video_id =Integer.valueOf(id);
        //根据id获取图片名字和视频名字
        Video video_name = videoService.findById(video_id);
        //根据id获取视屏路径和图片删除远程视屏和图片
        com.jcraft.jsch.Session session = JschUtil.getSession("47.102.198.5", 22, "root", "springboot2.0");/*("47.102.198.5", 22, "root", "springboot2.0");*/
        Sftp sftp = JschUtil.createSftp(session);
        //根据视频路径删除图片和和视频
       // System.out.println("/opt/static/image/"+video_name.getVideo_image().substring(32));
        boolean delImg = sftp.delFile("/opt/static/image/"+video_name.getVideo_image().substring(32));
        boolean delVideo = sftp.delFile("/opt/static/videos/"+video_name.getVideo_src().substring(33));
        System.out.println(delImg);
        System.out.println(delVideo);
        videoService.deleteVideo(video_id);
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
