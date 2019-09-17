package com.cxk.controller;

import com.cxk.service.DetailsService;
import com.cxk.service.DownLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/4 23:55
 * @Description：
 */
@Controller
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    private DetailsService detailsService;

    @Autowired
    private DownLoadService downLoadService;

    /**
     * 首页的展示 /index
     * 详情的页面 /details
     * 下载的功能 /download
     *
     * @return
     */

    @RequestMapping("/index/{id}/{ids}")
    public String index(Model model, @PathVariable("id") Integer id, @PathVariable("ids") Integer ids) {
        model.addAttribute("details", detailsService.selById(ids));
        model.addAttribute("downLoad", downLoadService.findById(id));
        return "index5";
    }

}
