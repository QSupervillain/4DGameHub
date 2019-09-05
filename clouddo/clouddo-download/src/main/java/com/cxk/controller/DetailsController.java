package com.cxk.controller;

import com.cxk.pojo.Details;
import com.cxk.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ：大大怪将军
 * @Date ：2019/9/4 23:55
 * @Description：
 */
@RestController
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    private DetailsService detailsService;

    /**
     *  首页的展示 /index
     *  详情的页面 /details
     *  下载的功能 /download
     * @return
     */

    @RequestMapping("/index")
    public String index(Integer id){
        Details details = detailsService.selById(id);
        System.out.println("details = " + details);
        return "success";
    }


}
