package com.cxk.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.extra.ssh.Sftp;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/file/{fileName}")
    public void file(HttpServletResponse response, @PathVariable String fileName) {
        System.out.println("fileName = " + fileName);
        com.jcraft.jsch.Session session = JschUtil.getSession("47.102.198.5", 22, "root", "springboot2.0");
        Sftp sftp = JschUtil.createSftp(session);
        sftp.download("/home/ftpuser/download/" + fileName + ".exe", FileUtil.file("C:\\Users\\Administrator\\Downloads\\load"));
        System.out.println("下载完成");
    }

}
