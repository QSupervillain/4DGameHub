package com.cxk.controller;

import com.cxk.pojo.GmNewsType;
import com.cxk.service.NewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author ：HeepEnd-ZH
 * @Date ：2019/9/9 16:47
 * @Description：
 */
@Controller
@RequestMapping("/index")
public class NewsController {

    @Autowired
    private NewsTypeService NewsTypeService;

    @RequestMapping("/load")
    public String load(){
        //
        List<GmNewsType> all = NewsTypeService.getAll();
        for (GmNewsType gmNewsType : all) {
            System.out.println("gmNewsType = " + gmNewsType);
        }
        return "news";
    }

}
