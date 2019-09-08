package com.cxk.controller;

import com.cxk.pojo.Pagination;
import com.cxk.pojo.Video;
import com.cxk.service.VideoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public Pagination<Video> fenYeNewVideo(String index){
        //获取页码
        int pageindex = Integer.valueOf(index);
        Page<Object> page = PageHelper.startPage(pageindex, 3);//每页显示3条数据
        List<Video> videos = videoService.fenYeNewVideo();
        Pagination<Video> pa = new Pagination<Video>();
        pa.setList(videos);
        pa.setPageIndex(page.getPageNum());
        pa.setPages(page.getPages());
        pa.setPageSize(page.getPageSize());
        pa.setTotal((int) page.getTotal());
        return pa;
    }
    /**
     *根据视屏类型分页显示相应数据
     * @return
     */
    @RequestMapping("/pageVideo")
    @ResponseBody
    public Pagination<Video> pageOriginalVideo(String video_type, String index){
        //获取页面返回的信息
        int video_type1 = Integer.valueOf(video_type);
        int pageindex = Integer.valueOf(index);
        System.out.println(video_type1+index);
        Page<Object> page = PageHelper.startPage(pageindex,3);//每页显示3条数据
        List<Video> videos = videoService.pageOriginalVideo(video_type1);
        Pagination<Video> pa = new Pagination<Video>();
        pa.setList(videos);
        pa.setPageIndex(page.getPageNum());
        pa.setPages(page.getPages());
        pa.setPageSize(page.getPageSize());
        pa.setTotal((int) page.getTotal());
        return pa;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/test")
    public String test(){
        return "Test";
    }
}
