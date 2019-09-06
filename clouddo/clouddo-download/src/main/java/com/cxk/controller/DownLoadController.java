package com.cxk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/4 23:48
 * @Description：
 */
@RestController
@RequestMapping("/download")
public class DownLoadController {

    /**
     * 首页的展示 /index
     * 详情的页面 /details
     * 下载的功能 /download
     *
     * @return
     */

    @RequestMapping("/file")
    public void file(HttpServletResponse response, String fileName) {
        String filePath = "http://image.nginx.com:22222/image/1.jpg";


    }

}
