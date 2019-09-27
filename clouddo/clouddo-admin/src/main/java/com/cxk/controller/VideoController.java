package com.cxk.controller;

import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import com.cxk.pojo.Video;
import com.cxk.service.VideoService;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class  VideoController {
    @Autowired
    private VideoService videoService;

    /**
     * 后台显示视屏信息
     */
    @RequestMapping("/videoslist")
    public String findAll(Model model) {
        List<Video> videos = videoService.findAll();
        model.addAttribute("videos", videos);
        //System.out.println(model);
        return "video-list";
    }

    @RequestMapping("/fuzzyQuery")
    @ResponseBody
    public List<Video> fuzzyQuery(String video_title, Model model) {
        System.out.println(video_title);
        List<Video> videos = videoService.fuzzyQuery(video_title);
        model.addAttribute("videos", videos);
        System.out.println(model);
        return videos;
    }

    @RequestMapping("/findById")
    public String findById(Model model, String video_id) {
        //获取id
        //System.out.println("join**************************");
        int video_ids = Integer.valueOf(video_id);
        //System.out.println(video_ids);
        Video videoById = videoService.findById(video_ids);
        model.addAttribute("videoById", videoById);
        //System.out.println(model);
        return "videos-edit";
    }

    @RequestMapping("/updateVideo")
    @ResponseBody
    public void updateVideo(String video_ids, String video_title, String video_content, String video_types) {
        //获取修改数据
        System.out.println("join******************************************************updateVideo");
        int video_id = Integer.valueOf(video_ids);
        System.out.println(video_id);
        int video_type = Integer.valueOf(video_types);
        System.out.println(video_type);
        System.out.println(video_title);
        int i = videoService.updateVideo(video_id, video_title, video_content, new Date(), video_type);
        //return "index";
    }

    @RequestMapping("/deleteVideoByid")
    @ResponseBody
    public void deleteVoidById(String id) {
        //System.out.println("join************deleteVideoByid");
        int video_id = Integer.valueOf(id);
        //根据id获取图片名字和视频名字
        Video video_name = videoService.findById(video_id);
        //根据id获取视屏路径和图片删除远程视屏和图片
        com.jcraft.jsch.Session session = JschUtil.getSession("47.102.198.5", 22, "root", "springboot2.0");/*("47.102.198.5", 22, "root", "springboot2.0");*/
        Sftp sftp = JschUtil.createSftp(session);
        //根据视频路径删除图片和和视频
        // System.out.println("/opt/static/image/"+video_name.getVideo_image().substring(32));
        if (video_id > 16) {
            System.out.println(video_name.getVideo_image().substring(33));
            System.out.println(video_name.getVideo_src().substring(40));
            boolean delImg = sftp.delFile("/home/ftpuser/www/images/"+video_name.getVideo_image().substring(33));
            boolean delVideo = sftp.delFile("/home/ftpuser/www/images/videos/"+video_name.getVideo_src().substring(40));
            videoService.deleteVideo(video_id);
        } else {
            boolean delImg = sftp.delFile("/opt/static/image/" + video_name.getVideo_image().substring(32));
            boolean delVideo = sftp.delFile("/opt/static/videos/" + video_name.getVideo_src().substring(33));
            //System.out.println(delImg);
            //System.out.println(delVideo);
            videoService.deleteVideo(video_id);
        }

    }

    /**
     * 视屏新增
     */
    @PostMapping(value = "/addVideo")
    public ModelAndView insertVideo(@RequestParam MultipartFile[] video_img, @RequestParam MultipartFile[] video_src, @RequestParam Map<String, Object> mp
            , ModelAndView model
    ) throws Exception {
        System.out.println("join*************************addVideo");
        //com.jcraft.jsch.Session session = JschUtil.getSession("47.102.198.5", 22, "root", "springboot2.0");("47.102.198.5", 22, "root", "springboot2.0");
        //Sftp sftp = JschUtil.createSftp(session);
        //Sftp video_imgs = sftp.put("C:\\Users\\kk\\Desktop\\gm_video\\"+imgs, "/opt/static/image/");
        // video_srcs = sftp.put("C:\\Users\\kk\\Desktop\\gm_video\\"+video, "/opt/static/videos/");
        //String video_title, String video_content, File video_src, File video_img, String video_type
        //String video_src,String video_image,String video_title, String video_content, Date video_date,int video_type
        // int video_types=Integer.parseInt(video_type);
        //int video_
        //产生随机数
        long totalMilliSeconds = System.currentTimeMillis();
        for (MultipartFile file : video_img) {
            //判断文件非空，上传
            if (!file.isEmpty()) {
                //1、连接ftp服务器
                FTPClient ftpClient = new FTPClient();
                ftpClient.setConnectTimeout(100000);
                ftpClient.connect("47.102.198.5", 21);
                //2、登录ftp服务器
                ftpClient.login("ftpuser", "root");
                ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
                //3、读取本地文件（获取本地文件的地址后，用于之后的上传）
                InputStream is = file.getInputStream();
                //4、上传文件
                // 1）指定上传目录
                ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/");
                //2）指定文件类型
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //第一个参数：文件在远程服务器的名称
                // 第二个参数：文件流
                ftpClient.storeFile( totalMilliSeconds+ ".jpg", is);
                //5、退出登录
                ftpClient.logout();
            }
        }

        for (MultipartFile file : video_src) {
            //判断文件非空，上传
            if (!file.isEmpty()) {
                //1、连接ftp服务器
                FTPClient ftpClient = new FTPClient();
                ftpClient.setConnectTimeout(100000);
                ftpClient.connect("47.102.198.5", 21);
                //2、登录ftp服务器
                ftpClient.login("ftpuser", "root");
                ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
                //3、读取本地文件（获取本地文件的地址后，用于之后的上传）
                InputStream is = file.getInputStream();
                //4、上传文件
                // 1）指定上传目录
                ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/videos/");
                //2）指定文件类型
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                //第一个参数：文件在远程服务器的名称
                // 第二个参数：文件流

                ftpClient.storeFile(+totalMilliSeconds + ".mp4", is);
                //5、退出登录
                ftpClient.logout();
            }
        }
        String video_srcc = "http://47.102.198.5:26666/images/videos/" + totalMilliSeconds + ".mp4";
        String video_imgg = "http://47.102.198.5:26666/images/" + totalMilliSeconds + ".jpg";
        String video_type = (String) mp.get("video_type");
        int video_types = Integer.parseInt(video_type);
        //System.out.println(video_type+"**********");
        videoService.insertVideo(video_srcc, video_imgg, (String) mp.get("video_title"), (String) mp.get("video_content"), new Date(), video_types);
        model.addObject("successful", "1");
        model.setViewName("videos-add");
        return model;
    }

    @RequestMapping("/test")
    public String test() {
        return "video-list";
    }
}
