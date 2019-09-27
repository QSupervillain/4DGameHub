package com.cxk.controller;

import com.cxk.pojo.GmNews;
import com.cxk.pojo.GmNewsType;
import com.cxk.service.NewsService;
import com.cxk.service.NewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author ：HeepEnd-ZH
 * @Date ：2019/9/9 16:47
 * @Description：
 */
@Controller
@RequestMapping("/news_type")
public class NewsTypeController {

    @Autowired
    private NewsTypeService newsTypeService;
    @Autowired
    private NewsService newsService;
    List<GmNews> newsAll;
    @RequestMapping("/load")
    public String load(Model model,@RequestParam(value = "typeID",defaultValue = "1") int typeId){
        //
        System.out.println("****************");
        System.out.println("typeId:"+typeId);
        System.out.println("****************");
        List<GmNewsType> typeAll = newsTypeService.getNewsTypeAll();
        for (GmNewsType gmNewsType : typeAll) {
            System.out.println("gmNewsType = " + gmNewsType);
        }
        if(typeId!=1){
            newsAll=newsService.getNewsByType(typeId);
        }else{
            newsAll=newsService.getNewsAll();
        }
        for (GmNews gmNews : newsAll) {
            System.out.println("新闻标题："+gmNews.getNews_title());
        }
        model.addAttribute("typeAll",typeAll);
        model.addAttribute("newsAll",newsAll);
        return "news";
    }
   /* @RequestMapping("")
    public String lodIndex(){
        return "index";
    }*/

}
